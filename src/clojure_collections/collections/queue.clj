(ns clojure-collections.collections.queue)

;; Queue

(def queue clojure.lang.PersistentQueue/EMPTY)

(seq (conj queue 1 2 3))
;; => (1 2 3)
;; => #object[clojure.lang.PersistentQueue 0x3c4f9a12 "clojure.lang.PersistentQueue@7861"]

;; Queue pattern
;; peek
;; conj
;; pop

(def queue (atom clojure.lang.PersistentQueue/EMPTY))

(swap! queue conj :a)
(swap! queue conj :b)
(swap! queue conj :c)
(swap! queue conj :d)
(swap! queue conj :e)
(seq @queue)
;; => (2 1 2 2)
;; => (1 2)

(defn my-pop []
  (let [[old _] (swap-vals! queue pop)]
    (peek old)))

;; Ordered
;; Duplicates
;; Count
;; sequential equality partition

(= () clojure.lang.PersistentQueue/EMPTY [])
;; => true
;; => true




