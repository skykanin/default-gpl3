(ns leiningen.new.default-gpl3
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "default-gpl3"))

(defn default-gpl3
  "Generate a simple Clojure project with a custom prompt"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' default-gpl3 project.")
    (->files data
             ["src/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["test/{{sanitized}}/core.clj" (render "core_test.clj" data)]
             ["project.clj" (render "project.clj" data)]
             ["LICENSE.md" (render "LICENSE.md" data)]
             [".gitignore" (render ".gitignore" data)])))
