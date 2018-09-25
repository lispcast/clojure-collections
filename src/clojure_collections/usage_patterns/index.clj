(ns clojure-collections.usage-patterns.index)

;; Index

;; HashMap
;;   Keys are all the same "kind"
;;   Values are all the same "kind"

;; Used to look things up

(def friends [{:name "Eric"
               :phone "504-302-3742"}
              {:name "Jane"
               :phone "50493-39202"}
              {:name "John"
               :phone "9494992023"}])

(def rolodex (into {} (for [friend friends]
                        [(:name friend) friend])))

rolodex;; =>
{"Eric" {:name "Eric", :phone "504-302-3742"},
 "Jane" {:name "Jane", :phone "50493-39202"},
 "John" {:name "John", :phone "9494992023"}}

(get rolodex "Jane");; => {:name "Jane", :phone "50493-39202"}

;; Accumulator index

;; Also used to accumulate values for given keys

(def visits (atom {}))

(defn log-visit! [url]
  (swap! visits update url (fnil inc 0)))

(def numbers [3 4 4 3 2 1 2 3 4 5 6 5 4 3 2 4 3 6 7 8 6 44 6 6])

(reduce (fn [idx n]
          (update idx
            (if (even? n) :even :odd)
            (fnil conj []) n))
  {} numbers)

;; Dispatch Table

;; For converting a value to a function

(def prep-routines {:coffee brew-coffee
                    :tea    make-tea
                    :bagel  prepare-bagel})

(defn prepare [item]
  (let [f (get prep-routines item)]
    (f)))

;; Conversion Table

;; statically convert one kind of thing to another

;; Create Read Update Delete

(def op-table {:post   :create
               :get    :read
               :put    :update
               :delete :delete})

(defn http->crud [method]
  (get op-table method))
