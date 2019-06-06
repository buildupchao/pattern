package com.pattern.designpattern.statemachine;

import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.UntypedStateMachine;
import org.squirrelframework.foundation.fsm.UntypedStateMachineBuilder;
import org.squirrelframework.foundation.fsm.annotation.StateMachineParameters;
import org.squirrelframework.foundation.fsm.impl.AbstractUntypedStateMachine;

/**
 * https://github.com/hekailiang/squirrel
 * @author buildupchao
 * @date 2019/06/06 16:40
 * @since JDK 1.8
 */
public class QuickStartExample {

	// 1.Define State Machine Event
	enum FSMEvent {
		ToA, ToB, ToC, ToD
	}
	
	// 2.Define State Machine Class
	@StateMachineParameters(stateType = String.class, eventType = FSMEvent.class, contextType = Integer.class)
	static class StateMachineSample extends AbstractUntypedStateMachine {
		protected void fromAToB(String from, String to, FSMEvent event, Integer context) {
			System.out.printf("Transition from '%s' to '%s' on event '%s'with context '%d'\n", from, to, event, context);
		}
		
		protected void ontoB(String from, String to, FSMEvent event, Integer context) {
			System.out.printf("Entry State '%s'\n", to);
		}
	}
	
	public static void main(String[] args) {
		// 3.Build State Transitions
		UntypedStateMachineBuilder builder = StateMachineBuilderFactory.create(StateMachineSample.class);
		builder.externalTransition().from("A").to("B").on(FSMEvent.ToB).callMethod("fromAToB");
		builder.onEntry("B").callMethod("ontoB");
		
		// 4.Use State Machine
		UntypedStateMachine fsm = builder.newStateMachine("A");
		fsm.fire(FSMEvent.ToB, 10);
		
		System.out.println("Current state is : " + fsm.getCurrentState());
	}
}
