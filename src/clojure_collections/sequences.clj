(ns clojure-collections.sequences)


;; sequences vs collections

(map inc [1 2 3]) ;; => (2 3 4)
(update [1 2 3] 1 -);; => [1 -2 3]

;; sequence operations
;; collection comes last

(map inc [1 2 3]);; => (2 3 4)
(filter even? [1 2 3]);; => (2)
(take 2 [1 2 3 4 5]);; => (1 2)
(drop 2 [1 2 3 4 5]);; => (3 4 5)
(drop 1 #{1 2 3 4 5 6}) ;; => (4 6 3 2 5)

(->> [1 2 3 4 5]
  (map inc)
  (filter even?)
  (drop 2))
;; => (6)

(def s (atom #{1 2 3 4 5}))

(swap! s (fn [s] (set (map inc s))))

;; collection operations
;; collection comes first

(update [1 2 3] 1 -);; => [1 -2 3]
(assoc [1 2 3] 1 4);; => [1 4 3]
(conj [1 2 3] 4);; => [1 2 3 4]
(conj #{1 2 3 4 5} 6) ;; => #{1 4 6 3 2 5}

(-> [1 2 3 4 5 6]
  (update 2 -)
  (assoc 0 :zero)
  (conj 7));; => [:zero 2 -3 4 5 6 7]

(def a (atom {}))

(swap! a assoc :key :value)
@a ;; => {:key :value}
