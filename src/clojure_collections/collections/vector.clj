(ns clojure-collections.collections.vector)

;; Vectors

[1 2 3 4]
;; => [1 2 3 4]
[]
;; => []

'(1 2 3 4)
;; => (1 2 3 4)

'(1 2 3 (* 2 2))
;; => (1 2 3 (* 2 2))

(list 1 2 3 4)
;; => (1 2 3 4)

[1 2 3 (* 2 2)];; => [1 2 3 4]

(vector 1 2 3 4)
;; => [1 2 3 4]

[1 :a "ere" 0 nil]
;; => [1 :a "ere" 0 nil]

(vec (list 1 2 3 4));; => [1 2 3 4]

(vec {:a 1 :b 2})
;; => [[:a 1] [:b 2]]

;; Access Patterns

;;; Order

(conj [1 2 3 4] :a)
;; => [1 2 3 4 :a]

(seq [1 2 3 4])
;; => (1 2 3 4)

;;; Random access by index

(def v [:a :b :c :e :f :g])

(get v 3)
;; => :e

(get v 1000)
;; => nil

(get v -1)
;; => nil

(get v :fff)
;; => nil

(nth v 3);; => :e
(nth v 100)

;; Keeping duplicates

v
;; => [:a :b :c :e :f :g]

(conj v :a)
;; => [:a :b :c :e :f :g :a]

;; Count

(count v)
;; => 6

;; Equality checks

(= [1 2 3 4] (list 1 2 3 4))
;; => true

(= [1 2 3 4] [1 2 3 4])
;; => true

(= [1 2 3 4] [1 2 3 (* 2 2)])
;; => true

;; Subvectors

v
;; => [:a :b :c :e :f :g]

(subvec v 0 3);; => [:a :b :c]

(conj (subvec v 0 3) :x);; => [:a :b :c :x]

;; Containment check

(def numbers [1 2 3 4 5 6])

(contains? numbers 4)
;; => true
(contains? numbers 2)
;; => true
(contains? numbers 0)
;; => true

;; contains? means is the index in the collection?

(contains? numbers 6)
;; => false
;; => true
;; => false
;; => false
;; => false

(loop [i 0]
  (if (contains? numbers i)
    (do
      (println (get numbers i))
      (recur (inc i)))
    (println "Done.")))

;; add and removing

v                                       
;; => [:a :b :c :e :f :g]
(conj v :x)
;; => [:a :b :c :e :f :g :x]
(pop v)
;; => [:a :b :c :e :f]
(peek v)
;; => :g

;; Tuple

[3.4 2.3 7.69]

;; Call as function

([:a :b :c :d] 0)
;; => :a

([:a :b :c :d] 10)

(numbers 2)

(map #(nth v %) [1 2 3 4 55 6])
(map v [1 2 3 4 55 6])
