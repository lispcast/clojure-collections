(ns clojure-collections.access-patterns.containment-check)

;; Containment check

;; Set

(def numbers (set (range 1000)))

(contains? numbers 10)
;; => true
(contains? numbers 100)
;; => true
(contains? numbers 24.5)
;; => false
(contains? numbers :ten)
;; => false

;; HashMaps

(contains? {:a 1 :b 2} :a)
;; => true
(contains? {:a 1 :b 2} :b)
;; => true
(contains? {:a 1 :b 2} 1);; => false
(contains? {:a 1 :b 2} 2);; => false

;; Vector
(contains? [10 20 30 40 50 60] 20);; => false
(contains? [10 20 30 40 50 60] 10);; => false
(contains? [10 20 30 40 50 60] 0);; => true
(contains? [10 20 30 40 50 60] 2);; => true
(contains? [10 20 30 40 50 60] 6);; => false
(contains? [10 20 30 40 50 60] -1);; => false
(contains? (vec (range 10 20)) 0);; => true
;; => true

(def x 10)

(if (< x (count v))
  ;;
  ;;
  )

(if (contains? v x)
  ;;
  ;;
  )

