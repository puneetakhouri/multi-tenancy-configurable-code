Suppose there is a method which is multi tenant and needs to do different things for different tenants, this code can help you to configure what needs to be done for each vertical as well the ordering, sequence, etc.

Example:
If there is a method to get Cart for a user and here is the config
Tenant 1
- Operation 1
- Operation 2
- Operation 3
- Operation 4

For Tenant 2
- Operation 2
- Operation 4

Even within the operations if for Tenant 1, the operation 2 needs to get data from database, whereas for Tenant 2 you need the operation 2 to get data from API, that can also be configured.

Added a controller and a service (TestService, please check the code to understand, almost everything required is there itself).
