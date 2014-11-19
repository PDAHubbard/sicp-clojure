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

(defn sum-square-larger [a b c]
  (defn square [n] (* n n))
  (- (apply + (map square (vector a b c)))
  	(square (min a b c))))

 (defn good-enough? [old-guess new-guess]
 		(< (/ (Math/abs (- old-guess new-guess))
 					old-guess)
 				0.0000001))

 (defn average [x y] 
 	(/ (+ x y) 2))

 (defn improve-sqrt [guess n]
 	(average guess (/ n guess)))

 	
(defn improve-cube [guess n]
		(/ (+ (/ n (* guess guess)) (* 2 guess)) 3))

(defn estimate-root [improve-func guess n]
	(let [new (improve-func guess n)]
		(if (good-enough? guess new) new
			(estimate-root improve-func new n))))
 

(defn sqrt [n]
 		(estimate-root improve-sqrt 1.0 n))

(defn cube-root [n]
	(estimate-root improve-cube 1.0 n))


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



  
  