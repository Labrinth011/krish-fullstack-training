import { json } from "stream/consumers";

export class OrderDispatchedEvent{
    constructor(
        public readonly orderRefId: number,
        public readonly requiredCapacity: number,
        public readonly fuelType: string,
    ){}

    toString(){
        return JSON.stringify({
            orderRefId: this.orderRefId,
            requiredCapacity: this.requiredCapacity,
            fuelType: this.fuelType,
        });
    }
}