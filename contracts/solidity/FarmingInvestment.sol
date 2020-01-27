pragma solidity ^0.4.17;

contract mortal {
    address owner;
    constructor() public { owner = msg.sender; }
    function kill() public { if (msg.sender == owner) selfdestruct(owner); }
}

contract farminginvestment is mortal {

    struct Investor{
        uint investedAmount;
        address payable id;
    }

    address payable cowBreeder;
    address payable farmer;

    uint milkPrice;

    uint collectedAmount;
    uint goalAmount;
    uint limitDate;
    boolean cowsBought;

    constructor(address payable _cowBreeder, uint _goalAmount, uint _milkPrice, uint duration) public{
        farmer = msg.sender;

        cowBreeder = _cowBreeder;
        milkPrice = _milkPrice;
        collectedAmount = 0;
        goalAmount = _goalAmount;
        limitDate = now + duration;

        cowsBought = false;

    }

// https://solidity.readthedocs.io/en/develop/miscellaneous.html?highlight=Pure
    function invest(uint amount) public view returns (boolean) {

	}

    function investmentPeriodEnd ()  {
        require(collectedAmount == goalAmount, "Goal amount of money has not yet been collected");
        cowBreeder.transfer(goalAmount);
        cowsBought = true;
    }

    function buyMilk payable (uint quantity) public {
        require (msg.value == milkPrice * quantity, "Not the right amount of money to buy that quantity of milk.");

    }



}
