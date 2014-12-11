(defproject sicp-clojure "0.0.1-SNAPSHOT"
  :description "Implementation of the SICP exercises in Clojure"
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :javac-options ["-target" "1.6" "-source" "1.6" "-Xlint:-options"]
  :aot [sicp-clojure.*]
  )
