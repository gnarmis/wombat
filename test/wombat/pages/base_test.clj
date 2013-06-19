(ns wombat.pages.base-test
  (:require [clojure.test :refer :all]
            [wombat.pages.base :refer :all]))

(deftest generate-base-test
  (testing "No keyword args"
    (is (= (generate-base)
           "<!DOCTYPE html>\n<html><head></head><body></body></html>")))
  (testing "Head content fill in"
    (is (= (generate-base :head-content [:title "foo"])
           (str "<!DOCTYPE html>\n<html>"
                "<head><title>foo</title></head>"
                "<body></body></html>"))))
  (testing "Body content fill in"
    (is (= (generate-base :body-content [:div "foo"])
           (str "<!DOCTYPE html>\n<html>"
                "<head></head>"
                "<body><div>foo</div></body></html>"))))
  (testing "Head and body content fill in"
    (is (= (generate-base :head-content [:title "foo"]
                          :body-content [:div "foo"])
           (str "<!DOCTYPE html>\n<html>"
                "<head><title>foo</title></head>"
                 "<body><div>foo</div></body></html>")))))
