(ns cyptography.polyAlphabeticCipher
  (:gen-class)
  (:require [cyptography.caeserEncryption :refer :all]))



(defn make-letter-groups [n text]
  (let [ASCII-groups (partition n (encrypt-to-ASCII text))
        char-groups (map (fn [groups]
                           (map (fn [ASCII-char]
                                  (str (char ASCII-char))) groups)) ASCII-groups)
        word-blocks (map (fn [groups]
                           (clojure.string/join "" groups)) char-groups)]
    (into [] word-blocks)))


(defn poly-alphabetic-encrpyt [n text]
  (let [grouped-text (make-letter-groups n text)]
    (mapv (fn [txt]
            (caeser-cipher-encryption n txt)) grouped-text)))


(defn poly-alphabetic-decrypt [n encrypt-text]
  (mapv (fn [txt]
          (cipher-decryption n txt)) encrypt-text))
