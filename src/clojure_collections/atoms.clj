(ns clojure-collections.atoms)

(def queue (atom [nil clojure.lang.PersistentQueue/EMPTY]))

(comment

  (swap! queue conj :a)
  (seq @queue)
  (peek @queue)
  (swap! queue pop)
  )

;; pre Clojure 1.9

(defn enqueue! [value]
  (swap! queue update 1 conj value)
  nil)

(defn dequeue! []
  (first (swap! queue (fn [[_ q]]
                        [(peek q)
                         (pop  q)]))))

(comment

  (enqueue! :a)
  (enqueue! :b)
  (dequeue!)

  )

;; post Clojure 1.9

(def queue19 (atom clojure.lang.PersistentQueue/EMPTY))

(defn enqueue19! [value]
  (swap! queue19 conj value)
  nil)

(defn dequeue19! []
  (let [[old new] (swap-vals! queue19 pop)]
    (peek old)))

(comment

  (enqueue19! :a)
  (enqueue19! :b)
  (seq @queue19)

  (dequeue19!)
  
  )
