(ns clojure-collections.usage-patterns.multi-comparison)

;; Multi-comparison

(defn vp? [name]
  (or (= name "John Joacobson")
    (= name "Linda Laurens")
    (= name "June James")
    (= name "Fred Franklin")
    ;; a lot more
    ))

(filter vp? employees)

;; Is it one of these?

(def vice-presidents #{"John Joacobson"
                       "Linda Laurens"
                       "June James"
                       "Fred Franklin"
                       ;; ...
                       })

(filter vice-presidents employees)

(#{1 2} 1);; => 1
(#{1 2} 2)
;; => 2

(#{1 2} 3);; => nil


(filter #{\a \e \i \o \u} "hello my name is eric");; => (\e \o \a \e \i \e \i)

(defn vowel? [letter]
  (contains? #{\a \e \i \o \u} letter))

;; trouble

(#{false} false)           ;; => false
(contains? #{false} false) ;; => true

(#{nil} nil)           ;; => nil
(contains? #{nil} nil) ;; => true
