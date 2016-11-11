curl -XPOST "http://localhost:8080/cashflow" -d "{ \"label\": \"buy a bike\", \"amount\": 50.2 }" --header "Content-Type:application/json"

curl -XGET "http://localhost:8080/cashflow"
