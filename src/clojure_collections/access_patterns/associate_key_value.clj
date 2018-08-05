(ns clojure-collections.access-patterns.associate-key-value
  (:require [clojure.string :as str]))

;; Associate key and value

;; HashMap (or Sorted Map)

(assoc {} :a 1)
;; => {:a 1}

(assoc {:a 1} :b 2 :c 3)
;; => {:a 1, :b 2, :c 3}

(assoc {:a 1} :b 2 :c 3 :a 9 :c 4)
;; => {:a 9, :b 2, :c 4}
;; => {:a 9, :b 2, :c 3}

;; Vector

(assoc [:A :B :C :D] 1 :one)
;; => [:A :one :C :D]

(assoc [:A :B :C :D] 10 :I)
;; throws IndexOutOfBoundsException

(assoc [:A :B :C :D] 4 :E)
;; => [:A :B :C :D :E]

(assoc [] :A 1)
;; throws IllegalArgumentException


(update {:a 1} :a inc);; => {:a 2}

(update {:a 1} :a + 4 6 8);; => {:a 5}
;; => {:a 19}

(update {:a []} :a conj 10);; => {:a [10]}

(update ["a" "b" "c"] 0 #(.toUpperCase %))
;; => ["A" "b" "c"]

(get-in {:a {:xs []}} [:a :xs])
;; => []

(update-in {:a {:xs []}} [:a :xs] conj 1)
;; => {:a {:xs [1]}}

(get-in {} [:a :xs])
;; => nil
(update-in {} [:a :xs] conj 1)
;; => {:a {:xs (1)}}

(assoc nil :a :val)
;; => {:a :val}
