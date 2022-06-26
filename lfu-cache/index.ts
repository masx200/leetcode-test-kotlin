import { DoublyLinkedList } from "../design-linked-list/DoublyLinkedList.ts";

class LFUCache {
    readonly #key_to_freq: Map<number, number> = new Map();
    readonly #key_to_value: Map<number, number> = new Map();
    readonly #freq_to_keys = new Map<number, Set<number>>();
    readonly #freq_to_node = new Map<number, DoublyLinkedList<number>>();
    readonly #capacity: number;
    readonly #freq_list_head = DoublyLinkedList<number>();
    readonly #freq_list_tail = DoublyLinkedList<number>();
    constructor(capacity: number) {
        if (capacity < 1) throw Error("capacity invalid");
        this.#capacity = capacity;
        this.#freq_list_head.next = this.#freq_list_tail;
        this.#freq_list_tail.prev = this.#freq_list_head;
    }
    #first_node() {
        return this.#freq_list_head.next === this.#freq_list_tail
            ? null
            : this.#freq_list_head.next;
    }
    #least_frequently_recently_used_key = (): number | undefined => {
        const least_freq_node = this.#first_node();
        const least_frequent = least_freq_node && least_freq_node.val;

        if (typeof least_frequent === "number") {
            const least_freq_keys = this.#freq_to_keys.get(least_frequent);
            if (least_freq_keys && least_freq_keys.size) {
                for (const key of least_freq_keys) {
                    return key;
                }
            }
        }
    };
    #delete(key: number): void {
        const freq = this.#key_to_freq.get(key);
        this.#key_to_freq.delete(key);
        this.#key_to_value.delete(key);
        if (typeof freq !== "undefined") {
            this.#remove_key_empty_freq_node(freq, key);
        }
    }
    #remove_key_empty_freq_node(freq: number, key: number) {
        const freq_set = this.#freq_to_keys.get(freq);
        freq_set && freq_set.delete(key);
        if (freq_set && freq_set.size === 0) {
            const node = this.#freq_to_node.get(freq);
            this.#freq_to_node.delete(freq);
            node && this.#remove_node(node);
        }
    }

    get #size() {
        return this.#key_to_freq.size;
    }
    #increase(key: number): void {
        const freq = (this.#key_to_freq.get(key) ?? 0) + 1;

        this.#key_to_freq.set(key, freq);
        this.#remove_key_empty_freq_node(freq - 1, key);

        if (!this.#freq_to_keys.has(freq)) {
            const node = DoublyLinkedList(freq);
            if (freq === 1) {
                this.#insert_First(node);

                this.#freq_to_node.set(freq, node);
            } else {
                const prev = this.#freq_to_node.get(freq - 1);
                if (!prev) {
                    throw new Error("accident prev is undefined");
                }
                this.#insert_After(prev, node);

                this.#freq_to_node.set(freq, node);
            }
        } else {
            const freq_set = this.#freq_to_keys.get(freq);
            freq_set && freq_set.add(key);
        }
    }

    #insert_First(node: DoublyLinkedList<number>): void {
        this.#insert_After(this.#freq_list_head, node);
    }
    #remove_node(node: DoublyLinkedList<number>): void {
        const prev = node.prev;
        const next = node.next;
        if (prev && next) {
            prev.next = next;

            next.prev = prev;
        } else {
            throw Error("next prev node not in list");
        }
    }
    #insert_After(
        prev_node: DoublyLinkedList<number>,
        new_node: DoublyLinkedList<number>
    ): void {
        const next = prev_node.next;
        const prev = prev_node;
        if (prev && next) {
            prev.next = new_node;
            new_node.prev = prev;
            new_node.next = next;
            next.prev = new_node;
        } else {
            throw Error("next prev_node not in list");
        }
    }
    get(key: number): number {
        const value = this.#key_to_value.get(key);
        if (typeof value === "number" && this.#has(key)) {
            this.#increase(key);
            return value;
        }
        return -1;
    }
    #has(key: number): boolean {
        return this.#key_to_value.has(key);
    }
    put(key: number, value: number): void {
        if (!this.#has(key)) {
            if (this.#size === this.#capacity) {
                const to_be_removed_key =
                    this.#least_frequently_recently_used_key();
                if (typeof to_be_removed_key === "number") {
                    this.#delete(to_be_removed_key);
                }
            }
        }
        this.#increase(key);
        this.#key_to_value.set(key, value);
    }
}
export default LFUCache;
