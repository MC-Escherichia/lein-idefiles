(ns leiningen.new.ide-files.util
  (:use [leiningen.new.templates :only [*dir* ->files *force?*]]))


(defn announce
  [subject proj-name]
  (println (format "Generating %s project files for '%s'" subject proj-name)))


(defn files
  [data & paths]
  (binding [*dir* "."
            *force?* true]
    (apply ->files data paths)))
