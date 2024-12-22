package com.florent.leetcode.listnode;

import com.florent.leetcode.listnode.utils.AssertListNode;
import com.florent.leetcode.listnode.utils.ListNodeDebugger;
import com.florent.leetcode.listnode.utils.ListNodeMaker;
import com.florent.leetcode.utils.ParameterizedIntList;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.florent.leetcode.listnode.utils.ListNodeMaker.makeListNode;

@Slf4j
public class ListNodeSolutionTest {

    @Nested
    class AddTwoNumbers {

        @ParameterizedTest
        @CsvSource({
                "2_4_3, 5_6_4, 7_0_8",
                "0, 0, 0",
                "9_9_9_9_9_9_9, 9_9_9_9, 8_9_9_9_0_0_0_1",
        })
        void shouldCombineTwoListNodes(ParameterizedIntList values1, ParameterizedIntList values2, ParameterizedIntList expectedValues) {
            var node1 = makeListNode(values1);
            var node2 = makeListNode(values2);

            var result = new ListNodeSolution().addTwoNumbers(node1, node2);

            var expectedListNode = ListNodeMaker.makeListNode(expectedValues);
            log.info("shouldCombineTwoListNodes : result({}, {}) -> {}",
                    ListNodeDebugger.toDebugString(node1), ListNodeDebugger.toDebugString(node2), ListNodeDebugger.toDebugString(expectedListNode));

            AssertListNode.expectListNodesAreEqual(result, expectedListNode);
        }

    }

}