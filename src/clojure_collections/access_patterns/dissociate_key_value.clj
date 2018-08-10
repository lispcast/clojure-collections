(ns clojure-collections.access-patterns.dissociate-key-value)

;; Dissociate a key and value

;; Hash Map (Sorted Map)

(dissoc {:a 1 :b 2} :a)
;; => {:b 2}

(dissoc {:a 1 :b 2} :c)
;; => {:a 1, :b 2}

(def visits (atom {}))

(defn record-visit! [ip]
  (swap! visits update ip (fnil inc 0)))

(comment
  (record-visit! "1.1.1.1")
  (record-visit! "1.1.1.2")
  (record-visit! "127.0.0.1"))

@visits
;; => {"1.1.1.1" 1, "1.1.1.2" 3, "127.0.0.1" 5}

(dissoc @visits "127.0.0.1")
;; => {"1.1.1.1" 1, "1.1.1.2" 3}
