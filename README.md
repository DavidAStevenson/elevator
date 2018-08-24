# elevator
Another GitHub elevator repo

Motivation: The elevators I use every day seem like, surely, surely, they could be controlled a little more efficiently (or maybe not). Through this side-project I will aim to see if I could possibly do any better, while also doing some:
- DDD (of the Domain of elevators)
- testing with some test frameworks, with a bit of test-first
- dependency injection with Guice - perhaps
  - if I get carried away I might make an elevator a standalone microservice that can be scaled, and use a service discovery mechanism instead
- event-emission to collaborate with other components of this awesome elevator control software (we shall see).

Initial features of the elevator
- as a user of an elevator, I want it to open its doors, so I can get on an off
- as a user of an elevator, I want it to go up and down to different floors, so I don't have to take the stairs
- as a user of an elevator, after getting on I want the option of indicating which floor I want to go to, so the elevator will know where to stop and open its doors for me
- as a user of an elevator, I want it to operate "safely", so that I don't get caught in a nasty accident
- as an operator of an elevator, I want the elevator to travel in one direction until all destination floors have been visited, as this would seem to be an efficient way to server the users
- as an operator of an elevator, I want the elevator to go idle if no users have indicated the want a lift, to save on electricity
- as an operator of an elevator, I want the elevator to go to the extreme end of the opposite range when users are waiting, so that it will be able to then bring all users wishing to have a lift in the opposite direction efficiently within minimum back-and-forth

Nice-to-have features
- capacity
- when at capacity, don't stop at floors where there are only more users waiting to get on
