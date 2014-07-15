(ns leiningen.new.ide-files.eclipse
  (:require [leiningen.new.ide-files.util :as util]
            [clojure.pprint :as pp])

  (:use [leiningen.new.templates :only [renderer sanitize]]))


(def render (renderer "ide_files/eclipse"))

(defn echo
  "Print and return the argument. Use for debugging."
  [x]
  (println "---------------")
  (pp/pprint x)
  x)

(defn eclipse
  [{:keys [group name classpath-jars all-source-paths compile-path]
    :as argmap}]
  (util/announce "Eclipse" name)
  (let [data {:name name
              :sanitized (sanitize name)
              :classpath-jars classpath-jars
              :source-dirs all-source-paths
              :compile-paths compile-path
              }
  	r #(render % data)]
    (util/files data
      [".classpath" (r "classpath")]
      [".project"   (r "project")])))
