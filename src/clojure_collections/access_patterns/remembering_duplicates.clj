(ns clojure-collections.access-patterns.remembering-duplicates)

;;; Remember duplicates

;; List

(conj () 1 2 3 4 5)
;; => (5 4 3 2 1)
(conj () 1 2 3 4 5 1 2 3 1 1 1)
;; => (1 1 1 3 2 1 5 4 3 2 1)
;; => (3 2 1 5 4 3 2 1)

;; Vector

(conj [] 1 2 3 4 5 1 2 3 1 1 1)
;; => [1 2 3 4 5 1 2 3 1 1 1]

;; Queue

(seq (conj clojure.lang.PersistentQueue/EMPTY 1 2 3 4 5 1 2 3 1 1 1))
;; => (1 2 3 4 5 1 2 3 1 1 1)


;;; Forget duplicates

;; Set

(conj #{} 1 2 3 4 5 1 2 3 1 1 1)
;; => #{1 4 3 2 5}

(conj #{} (list 1 2 3) [1 2 3])
;; => #{(1 2 3)}
(conj #{} [1 2 3] (list 1 2 3))
;; => #{[1 2 3]}

(meta (first (conj #{} (with-meta [1] {:a 1}) [1])))
;; => {:a 1}
;; => #{[1]}

(meta (first (conj #{} [1] (with-meta [1] {:a 1}))))
;; => nil

;; HashMap
(conj {} [[1] :a] [2 :a] [3 :a] [4 :a] [5 :a] [1 :b] [2 :b] [3 :b] [1 :c] [1 :d] [(list 1) :e])
;; => {[1] :e, 2 :b, 3 :b, 4 :a, 5 :a, 1 :d}
;; => {1 :e, 2 :b, 3 :b, 4 :a, 5 :a}

(def elevator-calls (atom []))

(defn press! [floor direction]
  (swap! elevator-calls conj [[floor direction] :called]))

(press! 3 :up)
;; => [[[3 :up] :called]]
;; => {[3 :up] :called}
(press! 3 :up)
;; => [[[3 :up] :called] [[3 :up] :called]]
;; => {[3 :up] :called}
