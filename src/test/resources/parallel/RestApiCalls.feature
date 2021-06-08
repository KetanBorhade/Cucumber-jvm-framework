Feature: REST scenarios

Scenario: Verify Get and POST REST calls
Given user perform get call on "https://jsonplaceholder.typicode.com/posts/1" url
Then verify response contains "sunt aut facere repellat provident occaecati excepturi optio reprehenderit" string
Then verify response contains "DoubleQuoteuserIdDoubleQuote: 1," string
When user perform get post call on "http://jsonplaceholder.typicode.com/posts" url with "{D_QtitleD_Q:D_QfooD_Q,D_QbodyD_Q: D_QbarD_Q,D_QuserIdD_Q: D_Q1D_Q}" json
Then verify response contains "foo" string
Then verify response contains "bar" string
Then verify response "201" code
Then verify post call "foo" title value
Then verify post call "bar" body value

