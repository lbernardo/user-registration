(ns user-registration.services.country-pages.mxpages
  (:require [user-registration.models.models :as model]))


(defn montar-cpf
  "deviolve a pagina do CPF em PT-br"
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (model/novo-header "Informe seu CPF"
                                          "precisamos do seu CPF para validar os dados")
                       (model/novo-input "string"
                                         "cpf"))



        bottom (conj clojure.lang.PersistentQueue/EMPTY
                     (model/novo-button "Continuar"))]
    (model/nova-pagina children bottom)))

(defn montar-nome-br
  "pagina do nome completo"
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (model/novo-header "Informe seu nome"
                                          "por favor insira seu nome completo")
                       (model/novo-input "string"
                                         "name"))

        bottom (conj clojure.lang.PersistentQueue/EMPTY
                     (model/novo-button "Continuar"))]
    (model/nova-pagina children bottom)))

(defn montar-email-br
  "pagina do nome completo"
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (model/novo-header "Informe seu email"
                                          "por favor informe um email valido")
                       (model/novo-input "string"
                                         "mail"))

        bottom (conj clojure.lang.PersistentQueue/EMPTY
                     (model/novo-button "Continuar" (model/nova-action "post" "/users")))]
    (model/nova-pagina children bottom)))

(defn montar-data-nascimento
  "pagina que pede a data de nascimento"
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (model/novo-header "Necesito tu fecha de nacimiento"
                                          "informar el día / mes / año")
                       (model/novo-input "datetime"
                                         "birthday"
                                         "00/00/0000"))
        bottom (conj clojure.lang.PersistentQueue/EMPTY
                     (model/novo-button "Continuar"))]
    (model/nova-pagina children bottom)))

(defn listar-paginas
  "Listar em ordem as paginas da aplicação"
  []
  (let [paginas (conj clojure.lang.PersistentQueue/EMPTY (montar-cpf) (montar-nome-br) (montar-data-nascimento) (montar-email-br))]
    {:pages paginas}))
