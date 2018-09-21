(ns clojure-collections.lifo)

;; LIFO last-in, first-out
;; stack

;; Vector

(def todos (atom ()))

(defn add-todo! [task]
  (swap! todos conj task))

(defn get-todo! []
  (let [[old new] (swap-vals! todos pop)]
    (peek old)))


;; Lists


