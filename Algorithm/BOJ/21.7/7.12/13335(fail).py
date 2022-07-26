#트럭

def solution(bridge_length, weight, truck_weights):
    answer = 0
    
    trucksLen = len(truck_weights)
    
    bridge = [0 for i in range(bridge_length)]
    bridgeOut = []
    
    nowWeight = 0
    nowTruck = 0
    
    while len(bridgeOut) < len(truck_weights):
        answer += 1
        if weight >= nowWeight + truck_weights[0]:
            nowWeight += truck_weights[0]
            bridge.append(truck_weights.pop(0))
            bridge.pop(0)
            truck_weights.append(1001)
        else:
            if bridge[0] != 0:
                nowWeight -= bridge[0]
                bridgeOut.append(bridge.pop(0))
                if weight >= nowWeight + truck_weights[0]:
                    nowWeight += truck_weights[0]
                    bridge.append(truck_weights.pop(0))
                    truck_weights.append(0)
                else:
                    bridge.append(0)
            else:
                bridge.append(0)
                bridge.pop(0)
        
    return answer

n, w, l = map(int, input().split())
bridge_length = list(map(int, input().split()))

print(solution(w, l, bridge_length))

