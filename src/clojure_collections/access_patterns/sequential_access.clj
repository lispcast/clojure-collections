(ns clojure-collections.access-patterns.sequential-access
  (:require [clojure.string :as str]))

;;; Arbitrary stable order

;;; List

() ;; => ()

(def l (list 1 2 3 4))

(seq l)
;; => (1 2 3 4)

(conj l :A)
;; => (:A 1 2 3 4)

(conj l :A :B :C)
;; => (:C :B :A 1 2 3 4)

(into l [10 20 30 40 50])
;; => (50 40 30 20 10 1 2 3 4)

;;; Vector

(def v [1 2 3 4 5])

(seq v)
;; => (1 2 3 4 5)

(conj v :A)
;; => [1 2 3 4 5 :A]

(into v [10 20 30 40 50])
;; => [1 2 3 4 5 10 20 30 40 50]

;;; Queue

(def q clojure.lang.PersistentQueue/EMPTY)

q
;; => #object[clojure.lang.PersistentQueue 0x46357026 "clojure.lang.PersistentQueue@1"]

(seq (conj q 1 2 3))
;; => (1 2 3)

;;; Sorted order

;; Sorted HashMap
(seq (hash-map :a 1 :b 2 ))
;; => ([:b 2] [:a 1])
;; => {:b 2, :a 1}

(def shm (sorted-map :a 1 :b 2))

(seq shm)
;; => ([:a 1] [:b 2])

(seq (sorted-map "zA" 1 "yB" 2))
;; => (["yB" 2] ["zA" 1])

(seq (sorted-map-by (fn [a b]
                      (compare (str/join (rest a)) (str/join (rest b))))
       "zA" 1 "yB" 2))
;; => (["zA" 1] ["yB" 2])

;; Sorted Set

(seq (set [1 2 3 4 5 6 7]))
;; => (7 1 4 6 3 2 5)
;; => (1 4 3 2)
(seq (sorted-set 1 2 3 4 5 6 7 0 -10))
;; => (-10 0 1 2 3 4 5 6 7)
;; => (1 2 3 4 5 6 7)
;; => (1 2 3 4)

(sorted-set-by (fn [a b]
                 (compare (:name a) (:name b)))
  {:name "Zelda"} {:name "Eric"} {:name "Jane"} {:name "John"})
;; => #{{:name "Eric"} {:name "Jane"} {:name "John"} {:name "Zelda"}}
;; => #{{:name "Eric"} {:name "Jane"} {:name "John"}}
;; => #{{:name "Eric"}}
;; => #{{}}
;; => #{1 2}
;; => #{1}
;; => #{}

(defn priority-order [a b]
  (compare (:priority a) (:priority b)))

(def todos (atom #{}))

(defn add-todo! [item]
  (swap! todos conj item))

(do
  (add-todo! {:priority 10 :name "Buy kitten"})
  (add-todo! {:priority 1 :name "Buy cat food"})
  (add-todo! {:priority 2 :name "Feed kitten"})

  (seq @todos
    )
  
  )
;; => ({:priority 10, :name "Buy kitten"} {:priority 1, :name "Buy cat food"} {:priority 2, :name "Feed kitten"})
;; => ({:priority 1, :name "Buy cat food"} {:priority 2, :name "Feed kitten"} {:priority 10, :name "Buy kitten"})
;; => ("Buy cat food" "Buy kitten" "Feed kitten")
;; => ("Buy kitten" "Buy cat food" "Feed kitten")
;; => ("Feed kitten" "Buy cat food" "Buy kitten")
;; => ("Buy kitten" "Buy cat food" "Feed kitten")
