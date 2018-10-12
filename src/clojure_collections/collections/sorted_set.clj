(ns clojure-collections.collections.sorted-set)

;; Sorted Set

(sorted-set 3 4 32 5 5 4 23 3  53 3 1)
;; => #{1 3 4 5 23 32 53}

(sorted-set "a" 1)

(sorted-set-by (comparator >) 4 3 24  5 4  23 4 5 2 23 4)
;; => #{24 23 5 4 3 2}


(sorted-set-by (fn [a b]
                 (compare (:name a) (:name b))) {:name "Eric"} {:name "John"} {:name "Alice"})
;; => #{{:name "Alice"} {:name "Eric"} {:name "John"}}
;; => #{:e :d :c :b :a}
;; => #{:a :b :c :d :e}

(into (sorted-set) #{:e :d :c :b :a})
;; => #{:a :b :c :d :e}
