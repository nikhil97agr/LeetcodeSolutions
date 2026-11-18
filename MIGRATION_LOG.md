# Migration classification — Batch 001

Branch: `organize/difficulty-batch-001`
Source: `src/`
Scope: first 50 eligible problem folders in alphabetical order with a Markdown statement and at least one Java/Python/C++/Go implementation.

Classification rule: 70% inherent problem challenge + 30% actual implementation complexity; LeetCode labels, acceptance rate and popularity were not used. Every item in this batch is algorithmic and therefore belongs under `Algorithm/`. Original `src/` folders are retained.

| # | Problem folder | Score | Assigned difficulty | Reason | Files copied |
|---:|---|---:|---|---|---:|
| 1 | `a_number_after_a_double_reversal_2238` | 12 | Easy | Direct digit/property observation; constant-time check. | 2 |
| 2 | `abbreviating_the_product_of_a_range_2222` | 78 | Hard | Large-product abbreviation needs leading/trailing digit tracking and trailing-zero handling. | 2 |
| 3 | `absolute_difference_between_maximum_and_minimum_k_elements_4158` | 31 | Easy | Straightforward top/bottom-k selection; small constraints. | 2 |
| 4 | `account_balance_after_rounded_purchase_2955` | 8 | Easy | Simple nearest-ten arithmetic and boundary handling. | 2 |
| 5 | `accounts_merge_721` | 53 | Medium | Email-based connected components with union-find and sorted output. | 2 |
| 6 | `add_binary_67` | 29 | Easy | Standard digitwise addition with carry across unequal lengths. | 2 |
| 7 | `add_bold_tag_in_string_616` | 69 | Hard | Multiple-pattern matching via KMP plus overlapping/adjacent interval consolidation. | 2 |
| 8 | `add_digits_258` | 18 | Easy | Repeated digit-sum arithmetic with a simple loop. | 2 |
| 9 | `add_edges_to_make_degrees_of_all_nodes_even_2596` | 59 | Medium | Parity reasoning and exhaustive cases over up to four odd-degree vertices. | 2 |
| 10 | `add_minimum_number_of_rungs_2066` | 27 | Easy | Single-pass greedy gap formula. | 2 |
| 11 | `add_one_row_to_tree_623` | 39 | Medium | Depth-aware tree recursion with root insertion and subtree preservation. | 2 |
| 12 | `add_strings_415` | 27 | Easy | Elementary decimal string addition with carry. | 2 |
| 13 | `add_to_array_form_of_integer_1031` | 30 | Easy | Digitwise addition across array and scalar representations. | 2 |
| 14 | `add_two_integers_2383` | 2 | Easy | Direct integer addition. | 2 |
| 15 | `add_two_numbers_2` | 32 | Easy | Linked-list traversal with elementary carry propagation. | 2 |
| 16 | `add_two_numbers_ii_445` | 39 | Medium | Reverse-order processing via stacks and carry propagation. | 2 |
| 17 | `add_two_polynomials_represented_as_linked_lists_1774` | 43 | Medium | Combine ordered polynomial terms and discard zero coefficients. | 2 |
| 18 | `adding_spaces_to_a_string_2232` | 17 | Easy | Single linear scan with ordered insertion indices. | 2 |
| 19 | `adding_two_negabinary_numbers_1148` | 63 | Medium | Non-standard negative-base carry transitions and normalization. | 2 |
| 20 | `additive_number_306` | 55 | Medium | Search over initial partitions and validate a sequence with large-integer arithmetic. | 2 |
| 21 | `adjacent_increasing_subarrays_detection_i_3612` | 24 | Easy | Direct bounded scan for two adjacent increasing windows. | 2 |
| 22 | `adjacent_increasing_subarrays_detection_ii_3619` | 48 | Medium | Track increasing-run lengths to derive the maximum adjacent window. | 2 |
| 23 | `advantage_shuffle_901` | 51 | Medium | Greedy assignment after sorting, with ordering of opponent values. | 2 |
| 24 | `aggregate_two_time_series_4338` | 47 | Medium | Ordered timestamp merge with next-available-value semantics. | 2 |
| 25 | `airplane_seat_assignment_probability_1362` | 37 | Medium | Requires recognizing a probability recurrence/symmetry invariant. | 2 |
| 26 | `alert_using_same_key_card_three_or_more_times_in_a_one_hour_period_1709` | 31 | Easy | Group times by person, sort, and inspect consecutive triples. | 2 |
| 27 | `alice_and_bob_playing_flower_game_3279` | 30 | Easy | Parity counting reduces the game outcome to a constant-time formula. | 2 |
| 28 | `alien_dictionary_269` | 70 | Hard | Infer precedence constraints, reject invalid prefixes/cycles, and topologically order characters. | 2 |
| 29 | `all_ancestors_of_a_node_in_a_directed_acyclic_graph_1431` | 56 | Medium | Topological propagation of ancestor sets through a DAG. | 2 |
| 30 | `all_divisions_with_the_highest_score_of_a_binary_array_2261` | 30 | Easy | Prefix counts evaluate every split in linear time. | 2 |
| 31 | `all_elements_in_two_binary_search_trees_1427` | 26 | Easy | Tree traversal followed by sorting; basic tree processing. | 2 |
| 32 | `all_nodes_distance_k_in_binary_tree_893` | 50 | Medium | Convert parent-child links to an undirected graph and BFS from the target. | 2 |
| 33 | `all_oone_data_structure_432` | 82 | Hard | Dynamic min/max frequency structure with strict O(1) operation requirements. | 2 |
| 34 | `all_paths_from_source_lead_to_destination_511` | 58 | Medium | DFS must detect cycles and ensure every reachable path terminates at destination. | 2 |
| 35 | `all_paths_from_source_to_target_813` | 42 | Medium | Backtracking enumeration of paths in a DAG. | 2 |
| 36 | `all_possible_full_binary_trees_930` | 49 | Medium | Recursive combinatorial construction with memoized subtree combinations. | 2 |
| 37 | `allocate_mailboxes_1571` | 72 | Hard | Partition DP over sorted houses with median-based group costs. | 2 |
| 38 | `alphabet_board_path_1238` | 25 | Easy | Coordinate mapping and deterministic movement, including the irregular final row. | 2 |
| 39 | `alt_and_tab_simulation_3538` | 55 | Medium | Maintain mutable order with indexed nodes in a custom doubly linked list. | 2 |
| 40 | `alternating_digit_sum_2630` | 18 | Easy | Simple digit extraction and alternating signs. | 2 |
| 41 | `alternating_groups_i_3463` | 20 | Easy | Check each circular triple directly. | 2 |
| 42 | `alternating_groups_ii_3483` | 48 | Medium | Circular sliding-window/run-length accounting. | 2 |
| 43 | `alternating_groups_iii_3527` | 86 | Hard | Online updates and size queries over circular alternating runs using ordered intervals and a segment tree. | 2 |
| 44 | `ambiguous_coordinates_834` | 57 | Medium | Backtracking over split points and decimal placements with leading/trailing-zero validity rules. | 2 |
| 45 | `amount_of_new_area_painted_each_day_2297` | 72 | Hard | Maintain and merge covered intervals while measuring newly covered portions. | 2 |
| 46 | `amount_of_time_for_binary_tree_to_be_infected_2461` | 49 | Medium | Model tree adjacency and perform multi-directional BFS from the start node. | 2 |
| 47 | `analyze_user_website_visit_pattern_1108` | 60 | Medium | Generate per-user ordered triples, deduplicate per user, and rank patterns with tie-breaking. | 2 |
| 48 | `android_unlock_patterns_351` | 54 | Medium | Backtracking over a constrained state space with skip dependencies and symmetry. | 2 |
| 49 | `angle_between_hands_of_a_clock_1446` | 18 | Easy | Direct angle arithmetic and minimum circular difference. | 2 |
| 50 | `angles_of_a_triangle_4266` | 30 | Easy | Triangle inequality plus the cosine rule for three sides. | 2 |

Batch totals: 50 problem folders; 100 files copied.
Verification: destination entries are built from the exact source blob SHAs; source paths are unchanged. Full tree verification follows the commit.


# Migration classification — Batch 002 (checkpoint 1)

Batch scope: alphabetical eligible problem folders 51–150 (planned 100); this checkpoint completes problems 51–70.

Classification: 70% inherent problem challenge + 30% actual implementation complexity. LeetCode's label is used only as a tie-breaker for genuinely borderline cases. All 20 reviewed here are algorithmic and go under `Algorithm/`. Source folders are retained unchanged.

| # | Problem folder | Score | Assigned difficulty | Reason | Files copied |
|---:|---|---:|---|---|---:|
| 51 | `ant_on_the_boundary_3311` | 20 | Easy | Single-pass accumulation of movement; check whether the running position crosses the boundary. | 2 |
| 52 | `append_characters_to_string_to_make_subsequence_2572` | 20 | Easy | Two-pointer subsequence scan; only count unmatched target suffix characters. | 2 |
| 53 | `append_k_integers_with_minimal_sum_2305` | 43 | Medium | Greedy selection of smallest allowed positive integers while excluding a set; arithmetic-series handling. | 2 |
| 54 | `apple_redistribution_into_boxes_3334` | 12 | Easy | Sort capacities and greedily take largest boxes until the required total is reached. | 2 |
| 55 | `apply_bitwise_operations_to_make_strings_equal_2632` | 27 | Easy | Bitwise reachability reduces to checking whether both strings contain a one. | 2 |
| 56 | `apply_discount_every_n_orders_1459` | 42 | Medium | Stateful cashier object combines product-price lookup, bill aggregation and periodic customer state. | 2 |
| 57 | `apply_discount_to_prices_2373` | 37 | Medium | Token validation and monetary formatting require careful parsing and exact two-decimal output. | 2 |
| 58 | `apply_operations_on_array_to_maximize_sum_of_squares_3153` | 72 | Hard | Bit-count redistribution across k constructed values maximizes a nonlinear sum under bitwise invariants. | 2 |
| 59 | `apply_operations_to_an_array_2551` | 22 | Easy | Sequential adjacent updates followed by stable zero compaction. | 2 |
| 60 | `apply_operations_to_make_all_array_elements_equal_to_zero_2878` | 48 | Medium | Greedy forced window operations with a running expiration count; linear-time invariant maintenance. | 2 |
| 61 | `apply_operations_to_make_string_empty_3308` | 36 | Medium | Frequency maxima plus last-occurrence ordering; moderate counting and ordering reasoning. | 2 |
| 62 | `apply_operations_to_make_sum_of_array_greater_than_or_equal_to_k_3328` | 34 | Easy | Optimize a simple increment-versus-duplicate tradeoff using a direct arithmetic search. | 2 |
| 63 | `apply_operations_to_make_two_strings_equal_3033` | 73 | Hard | Minimum-cost pairing of mismatch positions with local and global operations; nontrivial DP/optimization reasoning. | 2 |
| 64 | `apply_operations_to_maximize_frequency_score_3196` | 68 | Hard | Sort, prefix sums, median-cost windows and binary search over feasible frequency. | 2 |
| 65 | `apply_operations_to_maximize_score_3001` | 76 | Hard | Prime-factor scoring, asymmetric monotonic boundaries and greedy exponentiation over subarray contributions. | 2 |
| 66 | `apply_substitutions_3825` | 43 | Medium | Recursive dependency expansion over an acyclic replacement graph; nested substitutions and expansion order. | 2 |
| 67 | `arithmetic_slices_413` | 29 | Easy | Count extensions of contiguous equal-difference runs with a simple linear recurrence. | 2 |
| 68 | `arithmetic_slices_ii_subsequence_446` | 74 | Hard | Count arithmetic subsequences using pairwise differences and dynamic programming across index pairs. | 2 |
| 69 | `arithmetic_subarrays_1752` | 44 | Medium | For each range, verify a rearrangeable arithmetic progression using extrema, expected spacing and set membership. | 2 |
| 70 | `armstrong_number_1090` | 15 | Easy | Digit extraction and fixed-power summation with a direct comparison. | 2 |

Checkpoint totals: 20 problem folders; 40 files copied. Next problem to process: **71**. Batch 002 remains open through problem 150.


# Migration classification — Batch 002 (checkpoint 2)

Problems 71–90 (alphabetical eligible-problem order). Each problem folder was copied in full; original `src/` files are retained.

71. `arranging_coins_441` — Score 20 — Easy — Greedy row accumulation; straightforward linear simulation.
72. `array_nesting_565` — Score 53 — Medium — Permutation-cycle traversal with visited/memoization and cycle-length reasoning.
73. `array_of_doubled_pairs_991` — Score 51 — Medium — Frequency accounting and ordering by value magnitude, including negative and zero cases.
74. `array_partition_561` — Score 18 — Easy — Sorting and pairing adjacent values using a direct greedy argument.
75. `array_transformation_1175` — Score 29 — Easy — Repeated local simulation until a fixed point; small bounded input.
76. `array_with_elements_not_equal_to_average_of_neighbors_2085` — Score 43 — Medium — Constructive rearrangement requiring a non-obvious ordering invariant.
77. `as_far_from_land_as_possible_1117` — Score 57 — Medium — Multi-source shortest-path reasoning over a grid.
78. `assign_cookies_455` — Score 25 — Easy — Sort both arrays and apply a simple greedy matching.
79. `assign_elements_to_groups_with_constraints_3760` — Score 49 — Medium — Efficient divisor enumeration and earliest-index selection under large constraints.
80. `asteroid_collision_735` — Score 52 — Medium — Monotonic stack simulation with repeated collision resolution.
81. `available_captures_for_rook_1041` — Score 16 — Easy — Four directional scans on a fixed 8x8 board.
82. `average_height_of_buildings_in_each_segment_2142` — Score 67 — Hard — Sweep-line event aggregation, active-set averages, and coalescing adjacent equal segments.
83. `average_of_levels_in_binary_tree_637` — Score 28 — Easy — Level-order traversal with per-level aggregation.
84. `average_salary_excluding_the_minimum_and_maximum_salary_1584` — Score 14 — Easy — Single-pass min/max/sum aggregation.
85. `average_value_of_even_numbers_that_are_divisible_by_three_2542` — Score 12 — Easy — Simple filtering and integer average.
86. `average_waiting_time_1803` — Score 24 — Easy — Single-pass simulation of a single-server schedule and accumulated wait.
87. `avoid_flood_in_the_city_1612` — Score 64 — Medium — Greedy scheduling of dry days between repeated rains; ordered successor selection is central.
88. `backspace_string_compare_874` — Score 27 — Easy — Stack-based simulation of editor backspaces.
89. `bag_of_tokens_985` — Score 51 — Medium — Two-ended greedy with score/power trade-offs and invariant-based decisions.
90. `balance_a_binary_search_tree_1285` — Score 39 — Medium — Inorder traversal followed by balanced recursive reconstruction.

Checkpoint status: 90 of 150 problems in Batch 002 processed. Next problem: ordinal 91.


# Migration classification — Batch 003 (checkpoint 1)

91. `balanced_binary_tree_110` — Score 27 — Easy — Postorder height computation detects imbalance in linear time with a compact recursive invariant.
92. `balanced_k_factor_decomposition_3947` — Score 51 — Medium — Backtracking over nondecreasing divisors to form exactly k factors and minimize the spread.
93. `base_7_504` — Score 8 — Easy — Direct integer base conversion with sign handling delegated to a standard conversion routine.
94. `baseball_game_682` — Score 23 — Easy — Stack simulation of four local scoring operations with straightforward state updates.
95. `basic_calculator_224` — Score 58 — Medium — Single-pass expression evaluation with nested parentheses, unary minus, and sign-state management.
96. `basic_calculator_ii_227` — Score 47 — Medium — Operator-precedence evaluation using a stack and deferred accumulation of additive terms.
97. `basic_calculator_iii_785` — Score 68 — Hard — Recursive parsing of nested parentheses combined with multiplication/division precedence and queue-based evaluation.
98. `basic_calculator_iv_781` — Score 86 — Hard — Symbolic polynomial parsing, substitution, multiplication, coefficient aggregation, and canonical term ordering.
99. `battleships_in_a_board_419` — Score 30 — Easy — Connected-component traversal on a constrained grid; implementation uses a simple visited matrix.
100. `beautiful_arrangement_526` — Score 57 — Medium — Bitmask dynamic programming counts valid permutations under position-dependent divisibility constraints.
101. `beautiful_arrangement_ii_667` — Score 39 — Medium — Constructive alternating high-low arrangement creates exactly k distinct adjacent differences.
102. `beautiful_array_968` — Score 48 — Medium — Recursive odd-even transformation preserves the no-arithmetic-progression invariant.
103. `beautiful_pairs_2719` — Score 92 — Hard — Two-dimensional closest-pair-style optimization using sorting and segment trees with lexicographic tie handling.
104. `beautiful_towers_i_3114` — Score 58 — Medium — Enumerates peak positions and computes monotone sides; quadratic implementation is viable under the given bounds.
105. `beautiful_towers_ii_3113` — Score 70 — Hard — Monotonic-stack prefix/suffix contributions optimize the mountain profile to linear time.
106. `before_and_after_puzzle_1132` — Score 30 — Easy — Pairwise phrase matching, deduplication, and lexicographic sorting with direct string operations.
107. `best_meeting_point_296` — Score 54 — Medium — Manhattan-distance minimization relies on coordinate medians and aggregation across both dimensions.
108. `best_poker_hand_2433` — Score 13 — Easy — Counts five ranks and suits, then applies a short ordered set of classification rules.
109. `best_position_for_a_service_centre_1638` — Score 82 — Hard — Continuous two-dimensional geometric minimization requires numerical search and convergence reasoning.
110. `best_reachable_tower_4187` — Score 22 — Easy — Linear scan with Manhattan-distance filtering and deterministic lexicographic tie handling.

Checkpoint status: 20 of 100 problems in Batch 003 processed (overall eligible ordinals 91–110). Next problem: ordinal 111.


# Migration classification — Batch 004 (checkpoint 1)

111. `best_sightseeing_pair_1063` — Score 39 — Medium — Maintains the best transformed prior value to maximize the pair score in one pass.
112. `best_team_with_no_conflicts_1748` — Score 56 — Medium — Sorts by age/score and uses memoized sequence selection to maximize a compatible team.
113. `best_time_to_buy_and_sell_stock_121` — Score 19 — Easy — Single-pass minimum-price tracking and maximum profit calculation.
114. `best_time_to_buy_and_sell_stock_ii_122` — Score 37 — Medium — State-based dynamic programming for repeated buy/sell decisions under a one-share constraint.
115. `best_time_to_buy_and_sell_stock_iii_123` — Score 58 — Medium — Dynamic programming over day, holding state, and a bounded two-transaction count.
116. `best_time_to_buy_and_sell_stock_iv_188` — Score 63 — Medium — Generalizes trading-state DP to a variable transaction limit and tracks holding/transaction states.
117. `best_time_to_buy_and_sell_stock_using_strategy_3980` — Score 45 — Medium — Sliding-window profit adjustment combines fixed replacement actions with the unchanged outside contribution.
118. `best_time_to_buy_and_sell_stock_v_3892` — Score 64 — Medium — Three-state dynamic programming models normal and short-selling positions with a transaction budget.
119. `best_time_to_buy_and_sell_stock_with_cooldown_309` — Score 47 — Medium — State DP incorporates a cooldown transition that skips the day after selling.
120. `best_time_to_buy_and_sell_stock_with_cooldown_ii_4117` — Score 71 — Hard — DP tracks buy/sell timing, cooldown jumps, and duration-dependent holding costs.
121. `best_time_to_buy_and_sell_stock_with_transaction_fee_714` — Score 43 — Medium — Two-state dynamic programming accounts for a per-transaction fee.
122. `better_compression_of_string_3474` — Score 30 — Easy — Parses character-frequency pairs, aggregates a fixed alphabet, and emits sorted output.
123. `binary_digit_score_4449` — Score 12 — Easy — Counts set bits in two integers and applies direct arithmetic rules.
124. `binary_gap_899` — Score 17 — Easy — Scans set-bit positions and measures the largest gap between consecutive ones.
125. `binary_number_with_alternating_bits_693` — Score 13 — Easy — Checks adjacent binary digits with a simple linear bit scan.
126. `binary_prefix_divisible_by_5_1071` — Score 24 — Easy — Maintains a rolling binary prefix modulo five to avoid integer growth.
127. `binary_search_792` — Score 20 — Easy — Standard iterative binary search over a sorted array.
128. `binary_search_tree_iterator_173` — Score 43 — Medium — Implements lazy inorder traversal using an explicit stack of the left spine.
129. `binary_search_tree_iterator_ii_1729` — Score 56 — Medium — Maintains bidirectional traversal state and history for next/previous iterator operations.
130. `binary_search_tree_to_greater_sum_tree_1114` — Score 39 — Medium — Reverse inorder traversal propagates a running greater-value sum through the tree.

Checkpoint status: 20 of 100 problems in Batch 004 processed (overall eligible ordinals 111–130). Next problem: ordinal 131.


# Migration classification — Batch 004 (checkpoint 1)

111. `best_sightseeing_pair_1063` — Score 35 — Medium — Maintains the best prior value-minus-index to optimize the pair score in one pass.
112. `best_team_with_no_conflicts_1748` — Score 63 — Medium — Sorts by age and score, then applies subsequence dynamic programming under a conflict constraint.
113. `best_time_to_buy_and_sell_stock_121` — Score 22 — Easy — Single-pass minimum-so-far tracking for one buy-sell transaction.
114. `best_time_to_buy_and_sell_stock_ii_122` — Score 43 — Medium — State-based dynamic programming for repeated buy/sell decisions with a one-share constraint.
115. `best_time_to_buy_and_sell_stock_iii_123` — Score 62 — Medium — Dynamic programming tracks holding state and a strict limit of two completed transactions.
116. `best_time_to_buy_and_sell_stock_iv_188` — Score 67 — Hard — Generalized transaction-count DP with holding state and O(nk) state management.
117. `best_time_to_buy_and_sell_stock_using_strategy_3980` — Score 54 — Medium — Sliding-window optimization compares a baseline strategy with one constrained interval modification.
118. `best_time_to_buy_and_sell_stock_v_3892` — Score 74 — Hard — DP models normal and short-sale positions with transaction limits and strict sequential closure.
119. `best_time_to_buy_and_sell_stock_with_cooldown_309` — Score 48 — Medium — State DP with a nonlocal next-day transition enforcing cooldown after selling.
120. `best_time_to_buy_and_sell_stock_with_cooldown_ii_4117` — Score 84 — Hard — Multi-dimensional DP coordinates buy day, sell day, cooldown, and duration-dependent transaction fees.
121. `best_time_to_buy_and_sell_stock_with_transaction_fee_714` — Score 43 — Medium — Two-state dynamic programming incorporates a fee on each completed transaction.
122. `better_compression_of_string_3474` — Score 28 — Easy — Parses character-frequency pairs, aggregates counts, and emits a fixed alphabet order.
123. `binary_digit_score_4449` — Score 13 — Easy — Uses built-in population count and a direct conditional formula.
124. `binary_gap_899` — Score 22 — Easy — Scans bit positions and tracks distances between consecutive set bits.
125. `binary_number_with_alternating_bits_693` — Score 19 — Easy — Linear bit scan checks that adjacent bits alternate.
126. `binary_prefix_divisible_by_5_1071` — Score 32 — Easy — Maintains a running binary prefix modulo five to avoid integer growth.
127. `binary_search_792` — Score 23 — Easy — Standard iterative binary search with logarithmic time and simple interval invariants.
128. `binary_search_tree_iterator_173` — Score 39 — Medium — Maintains an explicit stack of the left spine to lazily produce inorder successors.
129. `binary_search_tree_iterator_ii_1729` — Score 51 — Medium — Bidirectional iterator requires maintaining traversal history and reversible cursor state.
130. `binary_search_tree_to_greater_sum_tree_1114` — Score 34 — Easy — Reverse-inorder traversal accumulates a suffix sum and updates nodes in place.

Checkpoint status: 20 of 100 problems in Batch 004 processed (overall eligible ordinals 111–130). Next problem: ordinal 131.


# Migration classification — Batch 005 (checkpoint 1)

131. `binary_searchable_numbers_in_an_unsorted_array_2111` — Score 43 — Medium — A value is guaranteed searchable exactly when it is no smaller than every preceding value and no larger than every following value; prefix maxima and suffix minima make the test linear.
132. `binary_string_with_substrings_representing_1_to_n_1065` — Score 45 — Medium — Checks a large range of binary substrings, converting and deduplicating candidate values while respecting the upper bound; the bounded substring enumeration is the key insight.
133. `binary_subarrays_with_sum_966` — Score 49 — Medium — Counts target-sum windows in a binary array using a specialized sliding-window invariant that tracks leading zero choices.
134. `binary_tree_cameras_1008` — Score 68 — Hard — A bottom-up tree DP/greedy state machine distinguishes uncovered, covered, and camera-placed nodes to achieve a global minimum.

Checkpoint status: 4 of 100 problems in Batch 005 processed (overall eligible ordinals 131–134). Next problem: ordinal 135.


# Migration classification — Batch 005 (checkpoint 2)

135. `binary_tree_coloring_game_1248` — Score 44 — Medium — Tree-subtree sizes partition the graph around the first player's chosen node; the winning move depends on comparing three connected regions.
136. `binary_tree_inorder_traversal_94` — Score 14 — Easy — A direct recursive inorder traversal visits left subtree, node, then right subtree.
137. `binary_tree_level_order_traversal_102` — Score 23 — Easy — Breadth-first traversal with a queue groups nodes by level using the current queue frontier.
138. `binary_tree_level_order_traversal_ii_107` — Score 28 — Easy — Standard level-order BFS followed by reversing the collected levels to produce bottom-up order.

Checkpoint status: 8 of 100 problems in Batch 005 processed (overall eligible ordinals 131–138). Next problem: ordinal 139.


# Migration classification — Batch 005 (checkpoint 3)

139. `binary_tree_longest_consecutive_sequence_298` — Score 37 — Medium — DFS carries the current increasing run and resets it at breaks while comparing the best path across both subtrees.
140. `binary_tree_longest_consecutive_sequence_ii_549` — Score 62 — Medium — Postorder DP returns separate increasing and decreasing chain lengths so a path can combine both directions through a node.
141. `binary_tree_maximum_path_sum_124` — Score 70 — Hard — Postorder tree DP distinguishes the best one-branch gain returned to the parent from a two-branch path that may form the global optimum.
142. `binary_tree_paths_257` — Score 24 — Easy — A straightforward DFS builds the root-to-leaf path string and records it when a leaf is reached.

Checkpoint status: 12 of 100 problems in Batch 005 processed (overall eligible ordinals 131–142). Next problem: ordinal 143.


# Migration classification — Batch 005 (checkpoint 4)

143. `binary_tree_postorder_traversal_145` — Score 14 — Easy — A direct recursive postorder traversal visits left subtree, right subtree, then the current node.
144. `binary_tree_preorder_traversal_144` — Score 14 — Easy — A direct recursive preorder traversal records the current node before visiting its two subtrees.
145. `binary_tree_pruning_832` — Score 37 — Medium — Postorder recursion must prune children first, then decide whether each parent subtree contains any one-valued node.
146. `binary_tree_right_side_view_199` — Score 39 — Medium — A level-order traversal visits right children first and records the first node at each depth.

Checkpoint status: 16 of 100 problems in Batch 005 processed (overall eligible ordinals 131–146). Next problem: ordinal 147.


# Migration classification — Batch 005 (checkpoint 5)

147. `binary_tree_tilt_563` — Score 28 — Easy — Postorder recursion returns each subtree sum and accumulates the absolute difference between left and right sums.
148. `binary_tree_upside_down_156` — Score 48 — Medium — Recursive pointer rewiring transforms each level while preserving the original right child as the new left child.
149. `binary_tree_vertical_order_traversal_314` — Score 48 — Medium — BFS tracks horizontal column indices and preserves top-to-bottom, left-to-right ordering while grouping nodes by column.
150. `binary_tree_zigzag_level_order_traversal_103` — Score 42 — Medium — Alternating level traversal changes child-push order across stack frontiers to produce zigzag ordering.

Checkpoint status: 20 of 100 problems in Batch 005 processed (overall eligible ordinals 131–150). Next problem: ordinal 151.


# Migration classification — Batch 006 (checkpoint 1)

151. `binary_trees_with_factors_843` — Score 49 — Medium — Sorted factorization DP counts ordered child-factor pairs for each product and accumulates tree counts modulo the required modulus.
152. `binary_watch_401` — Score 29 — Easy — Enumerates valid hour/minute bit combinations with a fixed small number of LEDs and filters values to legal clock ranges.
153. `bitwise_and_of_numbers_range_201` — Score 38 — Medium — Recognizes that the range AND is the common binary prefix of both bounds, implemented by clearing trailing set bits until they match.
154. `bitwise_or_of_adjacent_elements_3472` — Score 10 — Easy — A single linear pass applies bitwise OR to each adjacent pair.

Duplicate audit correction: removed duplicate destination copies for `binary_search_tree_to_greater_sum_tree_1114`, `best_time_to_buy_and_sell_stock_iv_188`, and `best_time_to_buy_and_sell_stock_v_3892`. Each now has exactly one destination under its logged difficulty.

Checkpoint status: 4 of 100 problems in Batch 006 processed (overall eligible ordinals 151–154). Next problem: ordinal 155.


# Migration classification — Batch 006 (checkpoint 2)

155. `bitwise_or_of_all_subsequence_sums_2644` — Score 45 — Medium — Uses the structural fact that OR over all subsequence sums can be obtained from the element values and running prefix sums, avoiding exponential subsequence enumeration.
156. `bitwise_or_of_even_numbers_in_an_array_4009` — Score 12 — Easy — A straightforward scan filters even values and accumulates their bitwise OR.
157. `bitwise_ors_of_subarrays_934` — Score 54 — Medium — Maintains the set of distinct OR values for subarrays ending at the current index; the bounded number of bitwise states avoids quadratic enumeration.
158. `bitwise_xor_of_all_pairings_2533` — Score 36 — Medium — Parity reasoning shows each element contributes to the total XOR only when the opposite array has odd length; this collapses a quadratic pairing process to linear scans.

Checkpoint status: 8 of 100 problems in Batch 006 processed (overall eligible ordinals 151–158). Next problem: ordinal 159.


# Migration classification — Batch 006 (checkpoint 3)

159. `block_placement_queries_3435` — Score 72 — Hard — Dynamic obstacle insertion and prefix-gap feasibility require coordinated ordered-set and distance-index structures to answer range queries efficiently.
160. `boats_to_save_people_917` — Score 39 — Medium — Sorting plus a two-pointer greedy pairs the lightest remaining person with the heaviest whenever feasible.
161. `bold_words_in_string_760` — Score 56 — Medium — Multiple-pattern matching with KMP, interval ordering, and overlap merging is needed to produce the minimum valid bold-tag spans.
162. `bomb_enemy_361` — Score 48 — Medium — Four directional scans accumulate enemy counts within wall-delimited row and column segments for each candidate cell.

Checkpoint status: 12 of 100 problems in Batch 006 processed (overall eligible ordinals 151–162). Next problem: ordinal 163.


# Migration classification — Batch 006 (checkpoint 4)

163. `booking_concert_tickets_in_groups_2380` — Score 73 — Hard — Supports constrained gather/scatter operations over many rows using a segment tree for range capacity queries and indexed allocation state.
164. `boundary_of_binary_tree_545` — Score 46 — Medium — Combines root handling, left-boundary preference, ordered leaf collection, and reversed right-boundary traversal without duplicates.
165. `brace_expansion_1076` — Score 40 — Medium — Builds Cartesian products of character-choice sets across tokens and deduplicates and sorts the resulting words.
166. `brace_expansion_ii_1188` — Score 71 — Hard — Parses nested grammar with union and concatenation precedence, recursively evaluating sets and Cartesian products.

Checkpoint status: 16 of 100 problems in Batch 006 processed (overall eligible ordinals 151–166). Next problem: ordinal 167.


# Migration classification — Batch 006 (checkpoint 5)

167. `break_a_palindrome_1252` — Score 33 — Easy — A greedy scan changes the earliest non-middle character that is not already 'a'; the final character handles the all-a case.
168. `brick_wall_554` — Score 38 — Medium — Counts aligned internal edge positions across rows and chooses the most frequent seam to minimize crossed bricks.
169. `bricks_falling_when_hit_821` — Score 70 — Hard — Stability propagation after sequential hits requires careful reverse restoration and connected-component reasoning over the grid.
170. `brightest_position_on_street_2075` — Score 43 — Medium — A sweep line over inclusive illumination intervals processes start/end events in coordinate order and tracks the earliest maximum overlap.

Checkpoint status: 20 of 100 problems in Batch 006 processed (overall eligible ordinals 151–170). Next problem: ordinal 171.


# Migration classification — Batch 006 (checkpoint 6)

171. `broken_calculator_1033` — Score 36 — Medium — Works backward from the target using parity-directed inverse operations, then finishes with direct decrements when the target falls below the start.
172. `buddy_strings_889` — Score 27 — Easy — Checks length and matching positions, then validates the single possible swap or a duplicate character for identical strings.
173. `build_a_matrix_with_conditions_2472` — Score 62 — Medium — Runs independent topological sorts for row and column precedence DAGs, detects cycles, then combines the two position mappings.
174. `build_an_array_with_stack_operations_1552` — Score 20 — Easy — Simulates the input stream and emits Push plus optional Pop operations until the target sequence is constructed.

Checkpoint status: 24 of 100 problems in Batch 006 processed (overall eligible ordinals 151–174). Next problem: ordinal 175.


# Migration classification — Batch 006 (duplicate-audit checkpoint)

The next eight eligible problems (ordinals 151–158) were already present in the destination before this batch. All eight source folders have exactly two corresponding destination files (statement and Java solution), and every destination blob SHA matches its source. They were skipped rather than copied again, preventing duplicate folders/files.

151. `binary_trees_with_factors_843` — existing destination: Algorithm/Medium
152. `binary_watch_401` — existing destination: Algorithm/Easy
153. `bitwise_and_of_numbers_range_201` — existing destination: Algorithm/Medium
154. `bitwise_or_of_adjacent_elements_3472` — existing destination: Algorithm/Easy
155. `bitwise_or_of_all_subsequence_sums_2644` — existing destination: Algorithm/Medium
156. `bitwise_or_of_even_numbers_in_an_array_4009` — existing destination: Algorithm/Easy
157. `bitwise_ors_of_subarrays_934` — existing destination: Algorithm/Medium
158. `bitwise_xor_of_all_pairings_2533` — existing destination: Algorithm/Medium

Batch 006: 8/100 problems accounted for; 0 new copies needed. Next problem: ordinal 159.


# Migration classification — Batch 006 (checkpoint 1)

Pre-existing destination audit: ordinals 151–174 (24 problems) were already organized. All source files in each folder have exact matching destination blob SHAs; no copies were made and no duplicates introduced.

Newly classified and copied:
175. `build_array_from_permutation_2048` — Score 12 — Easy — Directly applies the given nested indexing transformation in one pass.
176. `build_array_where_you_can_find_the_maximum_exactly_k_comparisons_1535` — Score 74 — Hard — Three-dimensional dynamic programming tracks position, current maximum, and search-cost count; the state transitions aggregate many choices under a modulus.
177. `build_binary_expression_tree_from_infix_expression_1736` — Score 70 — Hard — Two-stack parsing must correctly implement parentheses and operator precedence while constructing expression-tree nodes in operand order.
178. `building_boxes_1861` — Score 66 — Hard — Finds the minimum floor footprint by filling complete tetrahedral layers and then solving the residual triangular layer under a huge bound.

Batch 006 status: 28 of 100 problems accounted for (151–174 pre-existing and verified; 175–178 newly copied). Next problem: ordinal 179.


# Migration classification — Batch 006 (checkpoint 2)

179. `building_h2o_1186` — Score 58 — Medium — Semaphore coordination must release exactly two hydrogen threads before one oxygen thread and prevent interleaving between molecule groups.
180. `buildings_with_an_ocean_view_1909` — Score 32 — Easy — A right-to-left scan maintains the maximum height seen and collects strictly taller-than-all-to-the-right buildings.
181. `bulb_switcher_319` — Score 24 — Easy — The number of bulbs left on equals the count of perfect squares because only square-indexed bulbs have an odd number of divisors.
182. `bulb_switcher_ii_672` — Score 38 — Medium — The four toggle operations collapse into a small set of parity patterns; reasoning about equivalence and the press-count limit bounds the state space.

Batch 006 status: 32 of 100 problems accounted for (151–174 pre-existing and verified; 175–182 newly copied). Next problem: ordinal 183.


# Migration classification — Batch 006 (checkpoint 3)

183. `bulls_and_cows_299` — Score 35 — Medium — Counts exact-position matches first, then uses digit frequencies for unmatched positions so duplicates are not overcounted.
184. `burst_balloons_312` — Score 78 — Hard — Interval DP chooses the last balloon burst in each subinterval, converting a changing-neighbor process into optimal substructure.
185. `bus_routes_833` — Score 58 — Medium — Builds stop-to-route adjacency and runs BFS over routes to minimize the number of bus transfers across a large implicit graph.
186. `button_with_longest_push_time_3632` — Score 18 — Easy — A linear scan compares each event time with the previous timestamp and applies the smallest-index tie-break.

Batch 006 status: 36 of 100 problems accounted for (151–174 pre-existing and verified; 175–186 newly copied). Next problem: ordinal 187.


# Migration classification — Batch 006 (checkpoint 4)

187. `buy_two_chocolates_2756` — Score 17 — Easy — Tracks the two minimum prices in one pass and checks whether their sum fits the available money.
188. `calculate_amount_paid_in_taxes_1382` — Score 25 — Easy — Walks the sorted tax brackets once, applying each marginal rate to the portion of income in that bracket.
189. `calculate_delayed_arrival_time_2748` — Score 8 — Easy — Adds the delay and wraps the hour using modulo 24.
190. `calculate_digit_sum_of_a_string_2361` — Score 28 — Easy — Repeatedly groups the string into fixed-size chunks, sums each chunk's digits, and rebuilds the string.

Batch 006 status: 40 of 100 problems accounted for (151–174 pre-existing and verified; 175–190 newly copied). Next problem: ordinal 191.


# Migration classification — Batch 006 (checkpoint 5)

191. `calculate_money_in_leetcode_bank_1817` — Score 25 — Easy — Accumulates the weekday deposits while increasing each new week's Monday baseline by one.
192. `calculate_score_after_performing_instructions_3732` — Score 32 — Easy — Simulates deterministic instruction execution while a visited set detects the first repeated index.
193. `camelcase_matching_1080` — Score 39 — Medium — Two-pointer matching must consume the pattern in order while rejecting unmatched uppercase characters and allowing arbitrary lowercase insertions.
194. `campus_bikes_1052` — Score 45 — Medium — Generates all worker-bike pairs, sorts them by distance and tie-breakers, then greedily assigns unused endpoints.

Batch 006 status: 44 of 100 problems accounted for (151–174 pre-existing and verified; 175–194 newly copied). Next problem: ordinal 195.


# Migration classification — Batch 006 (checkpoint 6)

195. `campus_bikes_ii_1067` — Score 72 — Hard — Bitmask dynamic programming explores one-to-one assignments while minimizing total Manhattan cost across worker subsets and bike positions.
196. `can_convert_string_in_k_moves_1647` — Score 47 — Medium — Character shifts with equal residues must be scheduled at distinct increasing times separated by 26, requiring frequency-based feasibility checks.
197. `can_i_win_464` — Score 68 — Hard — Memoized game-state search over used-number subsets determines whether a player can force a win under optimal adversarial choices.
198. `can_make_arithmetic_progression_from_sequence_1626` — Score 22 — Easy — Sorting exposes the candidate common difference; one linear scan verifies every adjacent gap.

Batch 006 status: 48 of 100 problems accounted for (151–174 pre-existing and verified; 175–198 newly copied). Next problem: ordinal 199.


# Migration classification — Batch 006 (checkpoint 7)

199. `can_make_palindrome_from_substring_1281` — Score 51 — Medium — Prefix character-frequency counts answer each substring query by determining how many odd-frequency characters must be paired through replacements.
200. `can_place_flowers_605` — Score 28 — Easy — A greedy linear scan plants a flower whenever the current plot and both neighbors are empty.
201. `can_you_eat_your_favorite_candy_on_your_favorite_day_1872` — Score 48 — Medium — Prefix sums and interval bounds determine whether the target candy type can be reached on a given day under minimum and maximum daily consumption.
202. `candy_135` — Score 58 — Medium — The solution processes children in rating order and propagates neighbor constraints to compute a minimum valid candy assignment; sorting and dependency handling make it more involved than a basic scan.

Batch 006 status: 52 of 100 problems accounted for (151–174 pre-existing and verified; 175–202 newly copied). Next problem: ordinal 203.


# Migration classification — Batch 006 (checkpoint 7)

199. `can_make_palindrome_from_substring_1281` — Score 44 — Medium — Prefix character frequencies answer many substring queries; parity counts determine the minimum replacements needed to pair odd-frequency characters.
200. `can_place_flowers_605` — Score 22 — Easy — A single greedy scan places a flower whenever both adjacent plots are empty, including boundary positions.
201. `can_you_eat_your_favorite_candy_on_your_favorite_day_1872` — Score 48 — Medium — Prefix candy totals define the minimum and maximum cumulative consumption by a given day, enabling interval feasibility checks per query.
202. `candy_135` — Score 67 — Hard — Minimum assignments must satisfy both neighboring-rating constraints globally; processing ratings in sorted order propagates candy requirements across adjacent children.

Batch 006 status: 52 of 100 problems accounted for (151–174 pre-existing and verified; 175–202 newly copied). Next problem: ordinal 203.


# Migration classification — Batch 006 (checkpoint 8)

203. `candy_crush_723` — Score 47 — Medium — Repeatedly detects simultaneous horizontal and vertical matches, removes them together, applies gravity, and repeats until the board stabilizes.
204. `capacity_to_ship_packages_within_d_days_1056` — Score 48 — Medium — Binary-searches the minimum feasible ship capacity using a greedy linear simulation to test the required number of days.
205. `capitalize_the_title_2235` — Score 15 — Easy — Processes each word independently and applies the length-based capitalization rule.
206. `car_fleet_883` — Score 47 — Medium — Sorts cars by starting position and compares arrival times from nearest to farthest to merge cars that cannot pass one another.

Batch 006 status: 56 of 100 problems accounted for (151–174 pre-existing and verified; 175–206 newly copied). Next problem: ordinal 207.


Correction to Batch 006 checkpoint 8: `candy_135` was already present under Algorithm/Hard. The temporary duplicate copy under Algorithm/Medium has been removed. The existing Hard placement is retained; there is now one destination folder for this problem.


# Migration classification — Batch 006 (checkpoint 9)

207. `car_fleet_ii_1902` — Score 74 — Hard — A monotonic stack must discard cars that are unreachable or whose collision is superseded by a fleet they join, while calculating valid collision times.
208. `car_pooling_1184` — Score 35 — Medium — Trip start and end events are accumulated by location and swept in sorted order to maintain passenger occupancy.
209. `card_flipping_game_842` — Score 34 — Easy — A value is invalid only when it appears on both sides of the same card; scanning candidates against this forbidden set is straightforward.
210. `cat_and_mouse_949` — Score 88 — Hard — Game-theoretic retrograde analysis resolves win/loss states over mouse position, cat position, and turn while tracking remaining legal moves to identify forced outcomes.

Batch 006 status: 60 of 100 problems accounted for (151–174 pre-existing and verified; 175–210 newly copied). Next problem: ordinal 211.


# Migration classification — Batch 006 (duplicate-audit checkpoint 2)

Ordinals 207–210 were already present in their destination folders before this batch. Each has two source files and two matching destination blobs (exact SHA matches); skipped without copying:
- 207 `car_fleet_ii_1902` — Algorithm/Hard
- 208 `car_pooling_1184` — Algorithm/Medium
- 209 `card_flipping_game_842` — Algorithm/Easy
- 210 `cat_and_mouse_949` — Algorithm/Hard

Batch 006 status: 60 of 100 problems accounted for (151–174 and 207–210 pre-existing and verified; 175–206 newly copied). Next problem: ordinal 211.


# Migration classification — Batch 006 (checkpoint 10)

211. `cat_and_mouse_ii_1727` — Score 82 — Hard — Adversarial game search over cat position, mouse position, and turn order must reason about reachable moves and the finite turn limit.
212. `categorize_box_according_to_criteria_2619` — Score 16 — Easy — Checks independent dimension, volume, and mass thresholds and combines the resulting two category flags.
213. `cells_in_a_range_on_an_excel_sheet_2304` — Score 17 — Easy — Nested iteration over the bounded column and row ranges generates the requested cell labels in sorted order.
214. `cells_with_odd_values_in_a_matrix_1378` — Score 23 — Easy — Directly simulates row and column increments, then counts cells with odd values.

Batch 006 status: 64 of 100 problems accounted for (151–174 and 207–210 pre-existing and verified; 175–206 and 211–214 newly copied). Next problem: ordinal 215.
