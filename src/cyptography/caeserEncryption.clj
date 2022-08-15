(ns cyptography.caeserEncryption
  (:gen-class))


;;;;;;;;;;;;;;;;;;;;;;;;
;;;;    FUNCTIONS  ;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;


;;;;;;;;;;;;;;;;;;;;;;;;;
;; PHASE 1: ENCRYPTION ;;
;;;;;;;;;;;;;;;;;;;;;;;;;


(defn encrypt-to-ASCII [coll]
  (let [coll-letters (clojure.string/split (clojure.string/lower-case coll) #"")
        letters (clojure.string/join "" (remove #(= " " %) coll-letters))]
    (mapv int letters)))


(defn cipher-encryption [n coll]
  (let [message (encrypt-to-ASCII coll)]
    (mapv (fn [x]
            (cond
              (= x 122) (char 97)
              (> (+ n x) 122) (char (+ (- (+ n x) 122) 97))
              :else (char (+ n x)))) message)))


(defn caeser-cipher-encryption [n coll]
  (let [coll-letters (map str (cipher-encryption n coll))
        word (clojure.string/join "" coll-letters)]
    word))


;;;;;;;;;;;;;;;;;;;;;;;;;
;; PHASE 2: DECRYPTION ;;
;;;;;;;;;;;;;;;;;;;;;;;;;


(defn cipher-decryption [n coll]
  (let [encrypt-message (mapv int coll)]
    (mapv (fn [x]
            (cond
              (= x 97) (char 122)
              (< (- x n) 97) (char (- 122 (- 97 (- x n))))
              :else (char (- x n)))) encrypt-message)))


(defn caeser-ciper-decrypted [n encrypted-message]
  (clojure.string/join "" (map str (cipher-decryption n encrypted-message))))



