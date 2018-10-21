(ns clojure-collections.transients)

;; Transients

[] {} () #{}

(time (reduce conj #{} (range 1000000)))

(time (persistent! (reduce conj! (transient #{}) (range 1000000))))
