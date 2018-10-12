(ns clojure-collections.collections.sorted-map)

;; Sorted Map

(sorted-map :c 3 :b 2 :a 1 :z :f)
;; => {:a 1, :b 2, :c 3, :z :f}
;; => {:a 1, :b 2, :c 3}

(sorted-map-by (comparator <) 0 :a 1 :b 2 :c)
;; => {0 :a, 1 :b, 2 :c}
(sorted-map-by (comparator >) 0 :a 1 :b 2 :c)
;; => {2 :c, 1 :b, 0 :a}

(comparator )
(compare "a" "b")
;; => -1
(compare "a" "a")
;; => 0
(compare "b" "a")
;; => 1

(fn [a b] (- (compare a b)))

(fn [a b] (compare b a))

(defn sort-by-name [a b]
  (compare (:name a) (:name b)))

(sorted-map-by sort-by-name {:name "Eric"} 1 {:name "John"} 3 {:name "Andy"} 2)
;; => {{:name "Andy"} 2, {:name "Eric"} 1, {:name "John"} 3}

(into (sorted-map) {:a 1 :c 2 :z 4 :d 5}) ;; => {}
;; => {:a 1, :c 2, :d 5, :z 4}
