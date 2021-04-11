#!/bin/bash
curl -H "Authorization: Bearer $TOKEN" http://127.0.0.1:8080/secured/roles-allowed; echo
curl -H "Authorization: Bearer $TOKEN" http://127.0.0.1:8080/secured/roles-allowed-admin; echo


