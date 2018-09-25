(ns clojure-collections.usage-patterns.tuple)

;; Tuple

;; entity
{:first-name "Eric"
 :last-name "Normand"
 :phone "444-3322"
 :address "23 Jones St"
 :email "eric@lispcast.com"
 :dob nil}

;; tuple -- code smell! long tuple
["Eric" "Normand" "444-3322" "23 Jones St" "eric@lispcast.com" nil]


(re-find #"aa(b+)(d*)(c+)" "aabbcccd")
;; => ["aabbccc" "bb" "" "ccc"]
;; => ["aabbccc" "bb" "ccc"]

(let [[_ bs ds cs] (re-find #"aa(b+)(d*)(c+)" "aabbcccd")]
  )

(let [[old new] (swap-vals! (atom 0) inc)])
;; => [0 1]

{:new 1 :old 0}

(defn matching-as-bs-cs [s]
  (let [[_ bs ds cs] (re-find #"aa(b+)(d*)(c+)" s)]
    {:number-of-bs (count bs)
     :number-of-ds (count ds)
     :number-of-cs (count cs)}))

;; Variant Tuple

(defn get-file-location []
  ...)

[:url "http://storage.com/my-file.txt"]
[:disk "/home/eric/my-file.txt"]
[:paper 5 3 12]

{...

 :file-location [:url "http://storage.com/my-file.txt"]

 ...}

(defn fetch-file [location]
  (case (first location)
    :paper ...
    :disk ...
    :url ...))
