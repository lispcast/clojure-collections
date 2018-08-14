(ns clojure-collections.access-patterns.fifo
  (:require [clojure.java.io :as io]))

;; First-in, first-out, FIFO, Queue

;; Queue

(vec clojure.lang.PersistentQueue/EMPTY)
;; => []
;; => #object[clojure.lang.PersistentQueue 0x1be946a4 "clojure.lang.PersistentQueue@1"]

;; conj - add

(def empty-queue clojure.lang.PersistentQueue/EMPTY)

(vec (conj empty-queue :a :b :c))
;; => [:a :b :c]

;; peek - get next
(peek (conj empty-queue :a :b :c))
;; => :a
;; => :a
;; pop - drop next

(vec (pop (conj empty-queue :a :b :c)))
;; => [:b :c]
;; => #object[clojure.lang.PersistentQueue 0x69e40fad "clojure.lang.PersistentQueue@8de18200"]

;; Traverse file system

(def root (io/file "/Users/eric/projects/clojure-collections/src"))

(loop [q (conj empty-queue root)]
  (let [cur (peek q)]
    (cond
      (nil? cur)
      nil

      (.isDirectory cur)
      (recur (into (pop q) (.listFiles cur)))

      :else
      (do
        (println cur)
        (recur (pop q))))))





