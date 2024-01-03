- Reactive programing is a prog paradigm, basicaly data change changes the app
- Its basically about being notified about any changes in code and doing something with these changes its like a domino effect

# Flow
- its a kotlin feature that serves as a reactive programming framework
- It's all about being notified about changes in your code and sending then through a pipeline that potentially modifies them
- A flow is a coroutine that can emit multiple values over a period of time
- For instance:
  - say we get make an api request
  - get the response
  - we want to map the request to something else that we want to display in the UI
  - its basically a pipeline of actions
- A single suspend coroutine function can only return one value
- what if we want to do something with multiple response, for instance a countdown timeer that emits something every second

## Flow Operators:
- Filter

## State flow
- Is used to keep state
- It holds a value and updates it
- it always remembers Latest Value:
- state is always there

## Shared flow
- used to send one time events