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

    Investor[] investors;
    uint nbInvestors;

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
        nbInvestors = 0;

        cowsBought = false;

    }

    function invest() public payable {
    	// No arguments are necessary, all
        // information is already part of
        // the transaction. The keyword payable
        // is required for the function to
        // be able to receive Ether.

        // Revert the call if the investement period is over.
        require(
            now <= limitDate,
            "Investement period already ended."
        );
	
	    uint _investedAmount = msg.value;
	
	    // Vérifications que la somme ne dépasse pas le goal
	    require(
	        collectedAmount + _investedAmount <= goalAmount,
	        "Contract over invested: "+goalAmount-collectedAmount+" ETH missing to complete the goal."
	    );

	    // Si tout va bien jusque la, on accepte l'investisseur donc creation de l'investisseur
	    investors.push(Investor({investedAmount:_investedAmount, id:msg.sender}));

	    // On met à jour les params
	    nbInvestors = nbInvestors + 1;
	    collectedAmount = collectedAmount + investedAmount;

	    // End ?
	    if(collectedAmount == goalAmount){
	        investmentPeriodEnd();
	    }
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
