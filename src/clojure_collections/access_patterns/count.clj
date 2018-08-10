(ns clojure-collections.access-patterns.count)

;; Count

;; Strings

(count "1234")
;; => 4

;; Vector

(count [1 2 3 4])
;; => 4

;; List

;; Set

;; HashMap (sorted maps)

(count {:a 1})
;; => 1

;; Lazy Sequences

;; don't call count

;; Example

(def visits (atom {"1.1.1.1" 102
                   "2.2.2.2" 80
                   "127.0.0.1" 1008}))

(count @visits)
;; => 3

