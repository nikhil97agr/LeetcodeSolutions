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
