(defproject wombat "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [hiccup "1.0.3"]
                 [garden "0.1.0-beta3"]
                 [markdown-clj "0.9.28"]
                 [clj-yaml "0.4.0"]
                 [endophile "0.1.0"]]
  :resource-paths ["posts"
                   "public"
                   "src/wombat/assets"])
