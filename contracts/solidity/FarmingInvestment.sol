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

    function invest() public view payable {
    	// No arguments are necessary, all
        // information is already part of
        // the transaction. The keyword payable
        // is required for the function to
        // be able to receive Ether.

        // Revert the call if the investement
        // period is over.
        require(
            now <= limitDate,
            "Investement period already ended."
        );
	
	uint investedAmount = msg.value;
	
	//----
	    


        //if (highestBid != 0) {
            // Sending back the money by simply using
            // highestBidder.send(highestBid) is a security risk
            // because it could execute an untrusted contract.
            // It is always safer to let the recipients
            // withdraw their money themselves.
            //pendingReturns[highestBidder] += highestBid;
        //}
        //highestBidder = msg.sender;
        //highestBid = msg.value;
        //emit HighestBidIncreased(msg.sender, msg.value);

	}

    function investmentPeriodEnd ()  {
        require(
            collectedAmount == goalAmount,
             "Goal amount of money has not yet been collected"
        );

        cowBreeder.transfer(goalAmount);
        cowsBought = true;
    }

    function buyMilk payable (uint quantity) public {
        require (
            msg.value == milkPrice * quantity,
            "Not the right amount of money to buy that quantity of milk."
        );

        require (
            cowsBought = true,
            "Cows have not been bought yet"
        );

        //envoyer une partie au fermier
        farmer.transfer(msg.value * 0.5)

        // et une partie aux investors
        for (uint i = 0; i < nbInvestors; i++){
            //potentiellement problème d'approximation du calcul de la share?
            investors[i].id.transfer((investors[i].investedAmount / goalAmount)*msg.value)

        }

    }



}
