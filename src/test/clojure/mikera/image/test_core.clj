(ns mikera.image.test-core
  (:use mikera.image.core)
  (:use clojure.test)
  (:require [mikera.image.colours :refer [long-colour]])
  (:import [java.awt.image BufferedImage]))

(deftest test-new-image
  (is (instance? BufferedImage (new-image 10 10))))

(deftest test-scale-image
  (let [^BufferedImage bi (new-image 10 10)
        bi (scale-image bi 5 6)]
    (is (instance? BufferedImage bi))
    (is (== 5 (.getWidth bi)))
    (is (== 6 (.getHeight bi)))))

(deftest test-zoom-image
  (let [^BufferedImage bi (new-image 10 10)
        bi (zoom 2.0 bi)]
    (is (instance? BufferedImage bi))
    (is (== 20 (.getWidth bi)))
    (is (== 20 (.getHeight bi)))))

(deftest test-get-pixels
  (let [bi (new-image 1 1)
        pxs (get-pixels bi)]
    (is (instance? (Class/forName "[I") pxs))
    (is (= [0] (seq pxs)))
    (aset pxs 0 0xFFFFFFFF)
    (set-pixels bi pxs)
    (is (== 0xFFFFFFFF (long-colour (.getRGB bi 0 0))))))

(deftest test-load-image
  (let [^BufferedImage bi (load-image "mikera/image/samples/Clojure_300x300.png")]
    (is (instance? BufferedImage bi))
    (is (== 300 (.getWidth bi)))
    (is (== 300 (.getHeight bi)))))

