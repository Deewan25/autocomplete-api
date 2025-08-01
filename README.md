This is a Autocomplete all the suggestions for the given prefix feature.

Once import.sql is loaded into the H2 DB, During the bean creation for TrieService, A TrieNode data structure will constructed with all those names in it.

Functionality:
1. For a valid prefix
Pass the valid prefix to the query param
http://localhost:9090/autocomplete/v1/suggest?prefix=de

Expected response:
{"matches":["Devin","Devon","Derek"],"count":3,"prefix":"de"}

2. For a invalid prefix
Pass the invalid prefix to the query param
http://localhost:9090/autocomplete/v1/suggest?prefix=dee

Expected reponse:
{"error":"No names found matching the prefix","timestamp":"2025-08-01T19:33:07.879885100Z","prefix":"dee","status":404}

3. For a empty or null prefix
Pass the invalid prefix to the query param
http://localhost:9090/autocomplete/v1/suggest?prefix=

Expected reponse:
{"status":400,"timestamp":"2025-08-01T19:34:30.764897100Z","error":"Prefix cannot be empty"}
