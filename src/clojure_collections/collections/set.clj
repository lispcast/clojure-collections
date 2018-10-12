(ns clojure-collections.collections.set)

;; Sets

;; Literal syntax

#{} ;; => #{}

#{1 2 3 :a :b};; => #{1 3 2 :b :a}

#{1 2};; => #{1 2}

#{1 1.0}
;; => #{1.0 1}

(hash-set 1 2 3 4);; => #{1 4 3 2}

(set [1 2 3 4]);; => #{1 4 3 2}

(set (for [x (range 10)]
       ;;;
       x
       ))

;; Patterns

;;; no order

;;; forgets duplicates

(def a "abc")

(def s #{a})

(identical? s s)
;; => true

(identical? s (conj s "abc"))
;; => true
;; => true

;; lookup by value

(get s "abc")
;; => "abc"

(identical? (get s (String. "abc")) a)
;; => true
;; => true
(= a (String. "abc"))
;; => true
(identical? a (String. "abc"))
;; => false

;; count
(count s)
;; => 1

;; set equality partition

;; Removing an item

(disj s "ll")
;; => #{"abc"}
;; => #{}

;; Containment check

(contains? s "abc")
;; => true
(contains? s 123)
;; => false

;; Multi-comparison

(defn vp? [name]
  (or (= name "John")
    (= name "Linda")
    (= name "June")
    (= name "Fred")
    ;;;
    ))

(def vice-presidents #{"John" "Linda" "June" "Fred"})

(defn vp? [name]
  (contains? vice-presidents name))

(def attendance ["Eric" "John" "June" "Jane" "Laura"])

(filter vp? attendance)
;; => ("John" "June")
(filter vice-presidents attendance)
;; => ("John" "June")

(vice-presidents "John")
;; => "John"

(#{false} false) ;; => false
(#{nil} nil) ;; => nil
(contains? #{nil} nil);; => true


;; elevator

(def activated-buttons (atom #{}))

(defn push! [button-id]
  (swap! activated-buttons conj button-id))

(push! :first-floor)
;; => #{:first-floor}
;; => #{:first-floor}
