(ns clojure-collections.access-patterns.lookup-by-key)

;;; Lookup by key

;; Hash Map (or Sorted Map)

(def rolodex {"Eric" "504-333-2212"
              "Jane" "202-332-1233"
              "Joe"  "989-998-3321"})

(get rolodex "Jane")
;; => "202-332-1233"

(get rolodex "Fred" :unknown)
;; => :unknown
;; => nil

;; Vector

(def coordinates [10.2, 4.5, 8.9])

(def x (get coordinates 0))
(def y (get coordinates 1))
(def z (get coordinates 2))

(str x "; " y "; " z)
;; => "10.2; 4.5; 8.9"

;; Set (or Sorted Set)

(def friends #{"Eric" "Jane" "Joe"})

(get friends "Eric")
;; => "Eric"

(get friends "Fred")
;; => nil

(def t [1 2])

(def values #{t [3 4]})
(get values '(1 2))
;; => [1 2]

(identical? t t)
;; => true

(identical? t (get values '(1 2)))
;; => true


