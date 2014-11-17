(ns sicp-clojure.sec1-1
  (:gen-class))

(defn square [x]
	(* x x))

(defn sum-of-squares [x y]
	(+ (square x) (square y)))

(defn f [a]
	(sum-of-squares (+ a 1) (* a 2)))

(def a 3)
(def b (+ a 1))

(defn ex1-1 [x]
  (println (+ 5 3 4))
  (println (- 9 1))
  (println (/ 6 2))
  (println (+ (* 2 4) (- 4 6)))
  (println (+ a b (* a b)))				; 3 + 4 + 12 = 19
  (println (= a b))
  (println (if (and (> b a) (< b (* a b))) b a))

	(println
  (cond 
  		(= a 4) 6
  		(= b 4) (+ 6 7 a)						; 6+7+3=16
  		:else 25)
  		)

  (println (+ 2 (if (> b a) b a)))

  (println
  	(* (cond (> a b) a
  					 (< a b) b
  					 :else -1)
  			(+ a 1))									;4*4=16
  	)

  (println "Done.")
  )

(defn ex1-2 [x]
	(println
	(/ (+ 5 4 (- 2 (- 3 (+ 6 (/ 4 5))))) 
	   (* 3 (- 6 2) (- 2 7)))))



(defn ex1-3 [a b c]
;return sum of squares of the two larger numbers
;method: sum ALL squares, substract square of smallest
	
	(- (apply + (map square (vector a b c)))
		 (square (min a b c))))

(defn p []
	p)

(defn test [x y]
	(if (= x 0)
		0
		y))


  
  