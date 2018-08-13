(ns clojure-collections.access-patterns.removing-items)

;; Removing an item from a set

(def numbers #{1 2 3 4 5 6})

(disj numbers 6)
;; => #{1 4 3 2 5}
(disj numbers 2)
;; => #{1 4 6 3 5}

(disj numbers :not-there);; => #{1 4 6 3 2 5}

(dissoc {:a 1 :b 2} :a)
;; => {:b 2}

(def numbersv [1 2 3 4 5 6])

(pop numbersv)
;; => [1 2 3 4 5]

(defn mydisj [ls v]
  (vec (remove #(= v %) ls)))

(mydisj numbersv 6)
;; => [1 2 3 4 5]
