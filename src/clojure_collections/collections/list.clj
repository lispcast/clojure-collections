(ns clojure-collections.collections.list)

;; Lists

()
;; => ()

'(1 2 3 4);; => (1 2 3 4)

'(:a :b :c);; => (:a :b :c)

'(1 (+ 1 1) 3 4);; => (1 (+ 1 1) 3 4)

[1 (+ 1 1) 3 4];; => [1 2 3 4]

;; (1 (+ 1 1) 3 4)

(list 1 2 3)
;; => (1 2 3)
(list 1 (+ 1 1) 3)
;; => (1 2 3)

(cons 0 (list 1 2 3))
;; => (0 1 2 3)

(count (cons 0 (cons 1 (cons 2 (cons 3 nil)))))
;; => 4

(def a (list 1 2 3))

(into () [1 2 3])
;; => (3 2 1)

(identical? a a)
;; => true

(identical? a (seq a))
;; => true

(list? a) ;; => true
(seq?  a) ;; => true

(seq? [1 2 3]) ;; => false
(seq? (seq [1 2 3])) ;; => true
(list? (seq [1 2 3]));; => false


(defn f
  ([]
   ;;;
   )
  ([x]
   ;;;
   )
  ([x & xs]
   (let [xs (cons x xs)]
     (reduce (fn [a b])
       [] xs))))
