imagez
======

Image processing library for Clojure

Contains various utility functions for handling colours and images.

### Features

Features so far:

- Creating new images
- Scaling / zooming images
- Loading images from resource files
- Getting and setting pixels in bulk using primitive arrays
- Filtering images (blur, contrast, brightness etc.)
- Various colour handling functions
 
### Examples

```clojure
(use 'mikera.image.core)
(use 'mikera.image.colours)

;; create a new image
(def bi (new-image 32 32))

;; gets the pixels of the image, as an int array
(def pixels (get-pixels bi))

;; fill some random pixels with colours
(dotimes [i 1024]
  (aset pixels i (rand-colour)))
  
;; update the image with the newly changed pixel values
(set-pixels bi pixels)

;; view our new work of art
;; the zoom function will automatically interpolate the pixel values
(show bi :zoom 10.0 :title "Isn't it beautiful?")
```

For more examples including image filtering, see the demo namespace:

 - https://github.com/mikera/imagez/blob/master/src/test/clojure/mikera/image/demo.clj

### Requirements

Clojure 1.4 and above.

### License

LGPL version 3.0.
