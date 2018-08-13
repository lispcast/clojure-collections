(ns clojure-collections.equality-comparison)


;; Equality comparison

;; Java: ==

;; Clojure: =

(= [1 2 3] [1 2 3])
;; => true

;; Equality partitions

;; Sequential
;; interface java.util.List
;; classes java.util.LinkedList java.util.ArrayList

(= [1 2 3] '(1 2 3))
;; => true

(= [1 2 3] [3 2 1])
;; => false

(= 1 1 1 1 1 [2])
;; => false
;; => true
;; => true

;; Map equality partition
(= {:a 2} {:a 2})
;; => true
(= {:a 1 :b 2} {:b 2 :a 1})
;; => true
(= (hash-map :a 1 :b 2) (array-map :b 2 :a 1))
;; => true

;; Set equality partition
(= #{1 2 3} #{3 2 1})
;; => true

;; Across partitions
(= [1 2 3] #{1 2 3})
;; => false

(=
  (seq {:a 1 :b 2}) ;; => ([:a 1] [:b 2])
  (seq {:b 2 :a 1})) ;; => ([:b 2] [:a 1])
;; => false

(hash [1 2 3])  ;; => 736442005
(hash '(1 2 3)) ;; => 736442005

(def my-map {[1 2 3] :answer})

(get my-map [1 2 3]);; => :answer
(get my-map '(1 2 3));; => :answer
